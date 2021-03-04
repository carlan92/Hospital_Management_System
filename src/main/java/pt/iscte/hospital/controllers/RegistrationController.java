package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.NationalityService;
import pt.iscte.hospital.services.RegistrationService;
import pt.iscte.hospital.services.UserService;

import java.io.IOException;
import java.util.List;


@Controller
public class RegistrationController {
    // Attributes
    @Autowired
    private UserService userService;
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private NationalityService nationalityService;

    private static final String errorMsgName = "Nome inválido";
    private static final String errorMsgSex = "Escolha uma opção válida";
    private static final String errorMsgBirthday = "Data inválida";
    private static final String errorMsgAddress = "Endereço inválido";
    private static final String errorMsgPostCode = "Código postal inválido";
    private static final String errorMsgCity = "Nome de cidade inválida";
    private static final String errorMsgAccount = "Tipo de conta inválida";
    private static final String errorMsgNationality = "Escolha uma opção válida";
    private static final String errorMsgDocumentType = "Escolha uma opção válida";
    private static final String errorMsgDocumentNumber = "Número de documento inválido";
    private static final String errorMsgDocumentNumber2 = "Numero de documento já existe";
    private static final String errorMsgNif = "NIF inválido";
    private static final String errorMsgNif2 = "NIF já existe";
    private static final String errorMsgPatientNumber = "Número de utente inválido";
    private static final String errorMsgPatientNumber2 = "Numero de utente já existe";
    private static final String errorMsgPhone = "Número de telemóvel inválido";
    private static final String errorMsgEmail = "Este endereço já se encontra em utilização";
    private static final String errorMsgEmail2 = "Email inválido";
    private static final String errorMsgUsername = "Username já existe";
    private static final String errorMsgPassword = "Password inválida";
    private static final String errorMsgPassword2 = "Password não coincide";


    private static final String errorMsgPhotoUpload = "Erro ao fazer upload da imagem";
    private static final String errorMsgImageType = "Formato da imagem inválido. Usar jpg ou png.";
    private static final String errorMsgImageSize = "Tamanho máximo permitido para a foto é de %d MB"; // %d placehoder for an integer or long number


    // Methods
    @GetMapping(value = "/public/registration")
    public String showRegistrationPage(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityService.findAll();

        modelMap.put("nationalities", nationalities);
        modelMap.put("user", new Patient());

        return "public/registration";
    }

    @PostMapping(value = "/registrationToLogin")
    public String returnToLoginPage(@ModelAttribute Patient user,
                                    @RequestParam("file") MultipartFile file,
                                    ModelMap mpError,
                                    @RequestParam String confirmarPassword2) {

        List<Nationality> nationalities = nationalityService.findAll();

        mpError.put("nationalities", nationalities);

        boolean isFormValid = true;

        if (!registrationService.validName(user)) {
            mpError.put("errorMsgName", errorMsgName);
            isFormValid = false;
        }
        if (!registrationService.validPassword(user)) {
            mpError.put("errorMsgPassword", errorMsgPassword);
            isFormValid = false;
        }
        if (!user.getPassword().equals(confirmarPassword2)) {
            mpError.put("errorMsgPassword2", errorMsgPassword2);
            isFormValid = false;
        }
        if (!registrationService.validPhone(user)) {
            mpError.put("errorMsgPhone", errorMsgPhone);
            isFormValid = false;
        }
        if (!registrationService.validPostCode(user)) {
            mpError.put("errorMsgPostCode", errorMsgPostCode);
            isFormValid = false;
        }
        if (!registrationService.validSex(user)) {
            mpError.put("errorMsgSex", errorMsgSex);
            isFormValid = false;
        }
        if (!registrationService.validEmail(user)) {
            mpError.put("errorMsgEmail", errorMsgEmail);
            isFormValid = false;
        }
        if (!registrationService.validEmail2(user)) {
            mpError.put("errorMsgEmail", errorMsgEmail2);
            isFormValid = false;
        }
        if (!registrationService.validUsername(user)) {
            mpError.put("errorMsgUsername", errorMsgUsername);
            isFormValid = false;
        }
        if (!registrationService.validDocumentType(user)) {
            mpError.put("errorMsgDocumentType", errorMsgDocumentType);
            isFormValid = false;
        }
        if (!registrationService.validDocumentNumber(user)) {
            mpError.put("errorMsgDocumentNumber", errorMsgDocumentNumber);
            isFormValid = false;
        }
        if (!registrationService.validDocumentNumberUnique(user)) {
            mpError.put("errorMsgDocumentNumber", errorMsgDocumentNumber2);
            isFormValid = false;
        }
        if (!registrationService.validPatientNumber(user)) {
            mpError.put("errorMsgPatientNumber", errorMsgPatientNumber);
            isFormValid = false;
        }
        if (!registrationService.validPatientNumberUnique(user)) {
            mpError.put("errorMsgPatientNumber", errorMsgPatientNumber2);
            isFormValid = false;
        }
        if (!registrationService.validNif(user)) {
            mpError.put("errorMsgNif", errorMsgNif);
            isFormValid = false;
        }
        if (!registrationService.validNifUnique(user)) {
            mpError.put("errorMsgNif", errorMsgNif2);
            isFormValid = false;
        }
        if (!registrationService.validCity(user)) {
            mpError.put("errorMsgCity", errorMsgCity);
            isFormValid = false;
        }
        if (!registrationService.validAccount(user)) {
            mpError.put("errorMsgAccount", errorMsgAccount);
            isFormValid = false;
        }
        if (!registrationService.validBirthday(user)) {
            mpError.put("errorMsgBirthday", errorMsgBirthday);
            isFormValid = false;
        }
        if (!registrationService.validNationality(user)) {
            mpError.put("errorMsgNationality", errorMsgNationality);
            isFormValid = false;
        }
        if (!registrationService.validAddress(user)) {
            mpError.put("errorMsgAddress", errorMsgAddress);
            isFormValid = false;
        }


        if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
            try {
                String photoURL = imageUploadService.uploadImage(file, user.getUsername());
                user.setPhotoURL(photoURL);
            } catch (IOException e) {
                mpError.put("errorMsgPhotoUpload", errorMsgPhotoUpload);
                isFormValid = false;
            } catch (ImageTypeException e) {
                mpError.put("errorMsgPhotoUpload", errorMsgImageType);
                isFormValid = false;
            } catch (ImageSizeException e) {
                mpError.put("errorMsgPhotoUpload", String.format(errorMsgImageSize, imageUploadService.getImageMaxSize()));
                isFormValid = false;
            }
        } else {
            if (user.getSex().equals("Masculino")) {
                user.setPhotoURL("user-male.jpg");
            } else {
                user.setPhotoURL("user-female.jpg");
            }
        }

        if (!isFormValid) {

            mpError.put("user", user);

            return "registration";
        }

        // Add user to database
        userService.addUser(user);

        return "redirect:/public/login";
    }

}
