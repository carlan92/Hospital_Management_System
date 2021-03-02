package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.repositories.NationalityRepository;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.RegistrationService;
import pt.iscte.hospital.services.UserService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ChangeDataController {
    @Autowired
    UserService userService;
    @Autowired
    ImageUploadService imageUploadService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    NationalityRepository nationalityRepository;

    private static final String errorMsgName = "Nome inválido";
    private static final String errorMsgSex = "Escolha uma opção válida";
    private static final String errorMsgBirthday = "Data inválida";
    private static final String errorMsgAddress = "Endereço inválido";
    private static final String errorMsgPostCode = "Código postal inválido";
    private static final String errorMsgCity = "Nome de cidade inválida";
    private static final String errorMsgNationality = "Escolha uma opção válida";
    private static final String errorMsgDocumentType = "Escolha uma opção válida";
    private static final String errorMsgDocumentNumber = "Número de documento inválido";
    private static final String errorMsgNif = "Número de NIF inválido";
    private static final String errorMsgPatientNumber = "Número de utente inválido";
    private static final String errorMsgPhone = "Número de telemóvel inválido";

    private static final String errorMsgPhotoUpload = "Erro ao fazer upload da imagem";
    private static final String errorMsgImageType = "Formato da imagem inválido. Usar jpg ou png.";
    private static final String errorMsgImageSize = "Tamanho máximo permitido para a foto é de %d MB"; // %d placehoder for an integer or long number

    @GetMapping(value = "/change_data")
    public String goToChangeData(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityRepository.findAll();

        modelMap.put("nationalities", nationalities);
        modelMap.put("user", Login.getConnectedUser());
        return "change_data";
    }

    @PostMapping(value = "/change_data")
    public String returnToUserPage(ModelMap modelMap,
                                   @RequestParam("file") MultipartFile file,
                                   @RequestParam String name,
                                   @RequestParam String sex,
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   @RequestParam Date birthday,
                                   @RequestParam @Nullable String address,
                                   @RequestParam @Nullable String postCode,
                                   @RequestParam String city,
                                   @RequestParam String nationality,
                                   @RequestParam Long phone,
                                   @RequestParam String documentType,
                                   @RequestParam Long documentNumber,
                                   @RequestParam Long nif,
                                   @RequestParam @Nullable Long patientNumber) {

        // Update user info
        boolean isFormValid = true;
        Patient user = new Patient();

        user.setName(name);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setAddress(address);
        user.setPostCode(postCode);
        user.setCity(city);
        user.setNationality(nationality);
        user.setPhone(phone);
        user.setDocumentType(documentType);
        user.setDocumentNumber(documentNumber);
        user.setNif(nif);
        user.setPatientNumber(patientNumber);

        if (!registrationService.validName(user)) {
            modelMap.put("errorMsgName", errorMsgName);
            isFormValid = false;
        }
        if (!registrationService.validPhone(user)) {
            modelMap.put("errorMsgPhone", errorMsgPhone);
            isFormValid = false;
        }
        if (!registrationService.validPostCode(user)) {
            modelMap.put("errorMsgPostCode", errorMsgPostCode);
            isFormValid = false;
        }
        if (!registrationService.validSex(user)) {
            modelMap.put("errorMsgSex", errorMsgSex);
            isFormValid = false;
        }
        if (!registrationService.validDocumentType(user)) {
            modelMap.put("errorMsgDocumentType", errorMsgDocumentType);
            isFormValid = false;
        }
        if (!registrationService.validDocumentNumber(user)) {
            modelMap.put("errorMsgDocumentNumber", errorMsgDocumentNumber);
            isFormValid = false;
        }
        if (!registrationService.validPatientNumber(user)) {
            modelMap.put("errorMsgPatientNumber", errorMsgPatientNumber);
            isFormValid = false;
        }
        if (!registrationService.validNif(user)) {
            modelMap.put("errorMsgNif", errorMsgNif);
            isFormValid = false;
        }
        if (!registrationService.validCity(user)) {
            modelMap.put("errorMsgCity", errorMsgCity);
            isFormValid = false;
        }
        if (!registrationService.validBirthday(user)) {
            modelMap.put("errorMsgBirthday", errorMsgBirthday);
            isFormValid = false;
        }
        if (!registrationService.validNationality(user)) {
            modelMap.put("errorMsgNationality", errorMsgNationality);
            isFormValid = false;
        }
        if (!registrationService.validAddress(user)) {
            modelMap.put("errorMsgAddress", errorMsgAddress);
            isFormValid = false;
        }

        if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
            try {
                String photoURL = imageUploadService.uploadImage(file, user.getUsername());
                user.setPhotoURL(photoURL);
            } catch (IOException e) {
                modelMap.put("errorMsgPhotoUpload", errorMsgPhotoUpload);
                isFormValid = false;
            } catch (ImageTypeException e) {
                modelMap.put("errorMsgPhotoUpload", errorMsgImageType);
                isFormValid = false;
            } catch (ImageSizeException e) {
                modelMap.put("errorMsgPhotoUpload", String.format(errorMsgImageSize, imageUploadService.getImageMaxSize()));
                isFormValid = false;
            }
        } else {
            user.setPhotoURL(Login.getConnectedUser().getPhotoURL());
        }


        if (!isFormValid) {
            // case error in info validation
            modelMap.put("user", user);
            return "change_data";
        }
        user.setUserId(Login.getConnectedUser().getUserId());
        user.setEmail(Login.getConnectedUser().getEmail());
        user.setUsername(Login.getConnectedUser().getUsername());
        user.setPhotoURL(Login.getConnectedUser().getPhotoURL());
        user.setPassword(Login.getConnectedUser().getPassword());
        user.setAccount(Login.getConnectedUser().getAccount());

        userService.addUser(user);
        Login.setConnectedUser(user);

        return "redirect:/user";

    }

}
