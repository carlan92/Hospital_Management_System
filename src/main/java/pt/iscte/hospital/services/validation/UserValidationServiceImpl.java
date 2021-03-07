package pt.iscte.hospital.services.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.NationalityRepository;
import pt.iscte.hospital.repositories.UserRepository;
import pt.iscte.hospital.services.ErrorMessage;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.validation.UserValidationService;

import java.text.SimpleDateFormat;

@Service
public class UserValidationServiceImpl implements UserValidationService {
    // Attributes
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NationalityRepository nationalityRepository;
    @Autowired
    private ImageUploadService imageUploadService;

    private User user;
    private boolean isValid;
    private ModelMap errorModelMap;


    // Constructor
    public UserValidationServiceImpl() {
        isValid = true;
        errorModelMap = new ModelMap();
    }


    // Methods
    @Override
    public UserValidationService setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public UserValidationService validName() {
        String[] names = user.getName().split(" ");
        for (int i = 0; i < names.length; i++) {
            if (!names[i].matches("[A-Za-zÀ-ÿ']{2,}||[e]{1}")) {
                isValid = false;
                errorModelMap.put("errorMsgName", ErrorMessage.ERROR_MESSAGE_NAME.getErrorMsg());
                return this;
            }
        }
        return this;
    }

    @Override
    public UserValidationService validPhone() {
        String phone = String.valueOf(user.getPhone());
        if (!phone.matches("^9[1236][0-9]{7}$|^2[3-9][1-9][0-9]{6}$|^2[12][0-9]{7}$")) {
            isValid = false;
            errorModelMap.put("errorMsgPhone", ErrorMessage.ERROR_MESSAGE_PHONE.getErrorMsg());
        }
        return this;
    }

    @Override
    public UserValidationService validPassword() {
        // TODO para mais tarde repensar nas limitações
        if (!user.getPassword().matches(".{1,15}")) {
            isValid = false;
            errorModelMap.put("errorMsgPassword", ErrorMessage.ERROR_MESSAGE_PASSWORD.getErrorMsg());
        }
        return this;
    }

    @Override
    public UserValidationService samePassword(String passwordRetyped) {
        if (!user.getPassword().equals(passwordRetyped)) {
            isValid = false;
            errorModelMap.put("errorMsgPassword2", ErrorMessage.ERROR_MESSAGE_PASSWORD2.getErrorMsg());
        }
        return this;
    }

    @Override
    public UserValidationService validPostCode() {
        if (!user.getPostCode().matches("[0-9]{4}[-][0-9]{3}") || !user.getPostCode().matches("")) {
            isValid = false;
            errorModelMap.put("errorMsgPostCode", ErrorMessage.ERROR_MESSAGE_POST_CODE.getErrorMsg());
        }
        return this;
    }

    @Override
    public UserValidationService validSex() {
        if (!user.getSex().matches("Feminino") || !user.getSex().matches("Masculino")) {
            isValid = false;
            errorModelMap.put("errorMsgSex", ErrorMessage.ERROR_MESSAGE_SEX.getErrorMsg());
        }
        return this;
    }

    @Override
    public UserValidationService validEmail() {
        User userUnique = userRepository.findByEmail(user.getEmail());
        if (userUnique != null) {
            isValid = false;
            errorModelMap.put("errorMsgEmail", ErrorMessage.ERROR_MESSAGE_EMAIL.getErrorMsg());
        }
        return this;
    }

    @Override
    public UserValidationService validUsername() {
        User userUnique = userRepository.findByUsername(user.getUsername());
        if (userUnique != null) {
            isValid = false;
            errorModelMap.put("errorMsgUsername", ErrorMessage.ERROR_MESSAGE_USERNAME.getErrorMsg());
            return this;
        }
        return this;
    }

    @Override
    public UserValidationService validDocumentType() {
        if (user.getDocumentType().matches("Bilhete de Identidade")
                || user.getDocumentType().matches("Cartão de Cidadão")
                || user.getDocumentType().matches("Passaporte")) {
            return this;
        } else {
            isValid = false;
            errorModelMap.put("errorMsgDocumentType", ErrorMessage.ERROR_MESSAGE_DOCUMENT_TYPE.getErrorMsg());
            return this;
        }
    }

    @Override
    public UserValidationService validDocumentNumber() {
        if (user.getDocumentType().equals("Cartão de Cidadão")) {
            String cc = String.valueOf(user.getDocumentNumber());
            //todo deve aceitar o numero de documento ou basta numero civil??
            if (cc.matches("[0-9]{8}")) {
                return this;
            }
        }
        if (user.getDocumentType().equals("Bilhete de Identidade")) {
            String bi = String.valueOf(user.getDocumentNumber());
            if (bi.matches("[0-9]{8}")) {
                return this;
            }
        }
        if (user.getDocumentType().equals("Passaporte")) {
            String passaporte = String.valueOf(user.getDocumentNumber());
            //todo falta saber que condições o numero de passaporte deve aceitar??
            if (passaporte.matches("[0-9]{8}")) {
                return this;
            }
        }
        isValid = false;
        errorModelMap.put("errorMsgDocumentNumber", ErrorMessage.ERROR_MESSAGE_DOCUMENT_NUMBER.getErrorMsg());
        return this;
    }

    @Override
    public UserValidationService validPatientNumber() {
        if (user.getPatientNumber() == null) {
            return this;
        }
        String patientNumber = String.valueOf(user.getPatientNumber());
        if (patientNumber.matches("[0-9]{9}")) {
            return this;
        }
        isValid = false;
        errorModelMap.put("errorMsgPatientNumber", ErrorMessage.ERROR_MESSAGE_PATIENT_NUMBER.getErrorMsg());
        return this;
    }

    @Override
    public UserValidationService validNif() {
        String nif = String.valueOf(user.getNif());
        if (nif.matches("[0-9]{9}") || nif.matches("")) {
            return this;
        }
        isValid = false;
        errorModelMap.put("errorMsgNif", ErrorMessage.ERROR_MESSAGE_NIF.getErrorMsg());
        return this;
    }

    @Override
    public UserValidationService validEmail2() {
        // todo validação mais aproximada que consegui
        if (user.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,3}$")) {
            return this;
        }
        isValid = false;
        errorModelMap.put("errorMsgEmail", ErrorMessage.ERROR_MESSAGE_EMAIL2.getErrorMsg());
        return this;
    }

    @Override
    public UserValidationService validCity() {
        if (user.getCity().matches("^[A-Za-zÀ-ÿ'][a-zA-ZÀ-ÿ'\\s-]+[a-zA-ZÀ-ÿ']$")) {
            return this;
        }
        isValid = false;
        errorModelMap.put("errorMsgCity", ErrorMessage.ERROR_MESSAGE_CITY.getErrorMsg());
        return this;
    }

    @Override
    public UserValidationService validAccount() { // TODO ?
        if (user.getAccount().matches("Utente") || user.getAccount().matches("Funcionário")) {
            return this;
        } else {
            isValid = false;
            errorModelMap.put("errorMsgAccount", ErrorMessage.ERROR_MESSAGE_ACCOUNT.getErrorMsg());
            return this;
        }
    }

    @Override
    public UserValidationService validBirthday() {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(user.getBirthday());
        //validação feita a nivel dos campos. //todo validar a nivel de data real
        if (date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            return this;
        }
        isValid = false;
        errorModelMap.put("errorMsgBirthday", ErrorMessage.ERROR_MESSAGE_BIRTHDAY.getErrorMsg());
        return this;
    }

    @Override
    public UserValidationService validAddress() {
        String[] palavras = user.getName().split(" ");
        for (int i = 0; i < palavras.length; i++) {
            if (!palavras[i].matches("[A-Za-zÀ-ÿ'/-]{1,}")) {
                isValid = false;
                errorModelMap.put("errorMsgAddress", ErrorMessage.ERROR_MESSAGE_ADDRESS.getErrorMsg());
                return this;
            }
        }
        return this;
    }

    @Override
    public UserValidationService validNationality() {
        Nationality userNationality = nationalityRepository.findByName(user.getNationality());
        if (userNationality != null) {
            return this;
        }
        isValid = false;
        errorModelMap.put("errorMsgNationality", ErrorMessage.ERROR_MESSAGE_NATIONALITY.getErrorMsg());
        return this;
    }

    @Override
    public UserValidationService validNifUnique() {
        User nifUnique = userRepository.findByNif(user.getNif());
        if (nifUnique != null) {
            isValid = false;
            errorModelMap.put("errorMsgNif", ErrorMessage.ERROR_MESSAGE_NIF2.getErrorMsg());
            return this;
        }
        return this;
    }

    @Override
    public UserValidationService validPatientNumberUnique() {
        User patientNumberUnique = userRepository.findByPatientNumber(user.getPatientNumber());
        if (patientNumberUnique != null) {
            isValid = false;
            errorModelMap.put("errorMsgPatientNumber", ErrorMessage.ERROR_MESSAGE_PATIENT_NUMBER2.getErrorMsg());
            return this;
        }
        return this;
    }

    @Override
    public UserValidationService validDocumentNumberUnique() {
        User documentNumberUnique = userRepository.findByDocumentNumber(user.getDocumentNumber());
        if (documentNumberUnique != null) {
            isValid = false;
            errorModelMap.put("errorMsgDocumentNumber", ErrorMessage.ERROR_MESSAGE_DOCUMENT_NUMBER2.getErrorMsg());
            return this;
        }
        return this;
    }

    @Override
    public UserValidationService notValidPhotoUpload() {
        errorModelMap.put("errorMsgPhotoUpload", ErrorMessage.PHOTO_UPLOAD.getErrorMsg());
        isValid = false;
        return this;
    }

    @Override
    public UserValidationService notValidImageType() {
        errorModelMap.put("errorMsgPhotoUpload", ErrorMessage.IMAGE_TYPE.getErrorMsg());
        isValid = false;
        return this;
    }

    @Override
    public UserValidationService notValidImageSize() {
        errorModelMap.put("errorMsgPhotoUpload", String.format(ErrorMessage.IMAGE_SIZE.getErrorMsg(), imageUploadService.getImageMaxSize()));
        isValid = false;
        return this;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }

    @Override
    public ModelMap getErrorModelMap() {
        return errorModelMap;
    }
}