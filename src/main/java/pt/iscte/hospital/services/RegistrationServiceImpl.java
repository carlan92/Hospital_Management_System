package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.NationalityRepository;
import pt.iscte.hospital.repositories.UserRepository;

import java.text.SimpleDateFormat;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NationalityRepository nationalityRepository;


    public boolean validName(User user) {
        String[] names = user.getName().split(" ");
        for (int i = 0; i < names.length; i++) {
            if (!names[i].matches("[A-Za-zÀ-ÿ']{2,}||[e]{1}")) {
                return false;
            }
        }
        return true;
    }

    public boolean validPhone(User user) {
        String phone = String.valueOf(user.getPhone());
        if (!phone.matches("^9[1236][0-9]{7}$|^2[3-9][1-9][0-9]{6}$|^2[12][0-9]{7}$")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validPassword(User user) {
        //para mais tarde repensar nas limitações
        if (!user.getPassword().matches(".{1,15}")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validPostCode(User user) {
        if (user.getPostCode().matches("[0-9]{4}[-][0-9]{3}") || user.getPostCode().matches("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validSex(User user) {
        if (user.getSex().matches("Feminino") || user.getSex().matches("Masculino")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validEmail(User user) {
        User userUnique = userRepository.findByEmail(user.getEmail());
        if (userUnique != null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validUsername(User user) {
        User userUnique = userRepository.findByUsername(user.getUsername());
        if (userUnique != null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validDocumentType(User user) {
        if (user.getDocumentType().matches("Bilhete de Identidade") || user.getDocumentType().matches("Cartão de Cidadão") || user.getDocumentType().matches("Passaporte")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validDocumentNumber(User user) {
        if (user.getDocumentType().equals("Cartão de Cidadão")) {
            String cc = String.valueOf(user.getDocumentNumber());
            //todo deve aceitar o numero de documento ou basta numero civil??
            if (cc.matches("[0-9]{8}")) {
                return true;
            }
        }
        if (user.getDocumentType().equals("Bilhete de Identidade")) {
            String bi = String.valueOf(user.getDocumentNumber());
            if (bi.matches("[0-9]{8}")) {
                return true;
            }
        }
        if (user.getDocumentType().equals("Passaporte")) {
            String passaporte = String.valueOf(user.getDocumentNumber());
            //todo falta saber que condições o numero de passaporte deve aceitar??
            if (passaporte.matches("[0-9]{8}")) {
                return true;
            }
        }
        return false;
    }

    public boolean validPatientNumber(User user) {
        if(user.getPatientNumber()==null){
            return true;
        }
        String patientNumber = String.valueOf(user.getPatientNumber());
        if (patientNumber.matches("[0-9]{9}")) {
            return true;
        }
        return false;
    }

    public boolean validNif(User user) {
        String nif = String.valueOf(user.getNif());
        if (nif.matches("[0-9]{9}") || nif.matches("")) {
            return true;
        }
        return false;
    }

    public boolean validEmail2(User user) {
        // todo validação mais aproximada que consegui
        if (user.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,3}$")) {
            return true;
        }
        return false;
    }

    public boolean validCity(User user) {
        if (user.getCity().matches("^[A-Za-zÀ-ÿ'][a-zA-ZÀ-ÿ'\\s-]+[a-zA-ZÀ-ÿ']$")) {
            return true;
        }
        return false;
    }

    public boolean validAccount(User user) {
        if (user.getAccount().matches("Utente") || user.getAccount().matches("Funcionário")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validBirthday(User user){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date= simpleDateFormat.format(user.getBirthday());
        //validação feita a nivel dos campos. //todo validar a nivel de data real
        if(date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
            return true;
        }
        return false;
    }
    public boolean validAddress(User user){
        String[] palavras = user.getName().split(" ");
        for (int i = 0; i < palavras.length; i++) {
            if (!palavras[i].matches("[A-Za-zÀ-ÿ'/-]{1,}")) {
                return false;
            }
        }
        return true;
    }

    public boolean validNationality(User user){
        Nationality userNationality = nationalityRepository.findByName(user.getNationality());
        if (userNationality != null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validNifUnique(User user){
        User nifUnique = userRepository.findByNif(user.getNif());
        if (nifUnique != null) {
            return false;
        } else {
            return true;
        }
    }
    public boolean validPatientNumberUnique(User user){
        User patientNumberUnique = userRepository.findByPatientNumber(user.getPatientNumber());
        if (patientNumberUnique != null) {
            return false;
        } else {
            return true;
        }
    }
    public boolean validDocumentNumberUnique(User user){
        User documentNumberUnique = userRepository.findByDocumentNumber(user.getDocumentNumber());
        if (documentNumberUnique != null) {
            return false;
        } else {
            return true;
        }
    }

}

