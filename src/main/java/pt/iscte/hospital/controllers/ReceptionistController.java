package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.services.RegistrationService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.util.Date;

@Controller
public class ReceptionistController {
    // Attributes
    @Autowired
    SpecialityService specialityService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserService userService;

    private static final String errorMsgSpeciality = "Já existe essa especialidade";
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
    private static final String errorMsgNif = "Número de NIF inválido";
    private static final String errorMsgPatientNumber = "Número de utente inválido";
    private static final String errorMsgPhone = "Número de telemóvel inválido";
    private static final String errorMsgEmail = "Este endereço já se encontra em utilização";
    private static final String errorMsgEmail2 = "Email inválido";
    private static final String errorMsgUsername = "Username já existe";
    private static final String errorMsgPassword = "Password inválida";
    private static final String errorMsgPassword2 = "Password não coincide";

    // Constructor

    // Methods
    @GetMapping(value = "/add-speciality")
    public String addSpecialityPage(){
        return ("add-speciality");
    }

    @GetMapping(value = "/add-patient")
    public String addPatientPage(){
        return ("add-patient");
    }

    @PostMapping(value = "/add-speciality")
    public String addSpecialityService(@RequestParam String name_speciality, ModelMap mpError){

        Speciality speciality = new Speciality(name_speciality);
        if(!specialityService.validSpeciality(speciality)){
            mpError.put("errorMsgSpeciality",errorMsgSpeciality);
            return "add-speciality";
        }
        specialityService.addSpeciality(speciality);

        return ("redirect:/main");
    }
    @PostMapping(value = "/add-patient")
    public String addPatient(@ModelAttribute Patient user,
                             ModelMap mpError,
                             @RequestParam String name,
                             @RequestParam String password,
                             @RequestParam String confirmarPassword2,
                             @RequestParam String sex,
                             @RequestParam String nationality,
                             @RequestParam @Nullable String address,
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                 @RequestParam Date birthday,
                             @RequestParam @Nullable String postCode,
                             @RequestParam String city,
                             @RequestParam String account,
                             @RequestParam Long phone,
                             @RequestParam @Nullable Long patientNumber,
                             @RequestParam String documentType,
                             @RequestParam Long documentNumber,
                             @RequestParam Long nif,
                             @RequestParam String username,
                             @RequestParam String email){
        boolean isFormValid = true;

        if (!registrationService.validName(user)) {
            mpError.put("errorMsgName", errorMsgName);
            isFormValid = false;
        }
        if (!registrationService.validPassword(user)) {
            mpError.put("errorMsgPassword", errorMsgPassword);
            isFormValid = false;
        }
        if (!password.equals(confirmarPassword2)) {
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
        if (!registrationService.validPatientNumber(user)) {
            mpError.put("errorMsgPatientNumber", errorMsgPatientNumber);
            isFormValid = false;
        }
        if (!registrationService.validNif(user)) {
            mpError.put("errorMsgNif", errorMsgNif);
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

        if (!isFormValid) {

            mpError.put("returnName",name);
            mpError.put("returnSex",sex);
            mpError.put("returnBirthday", birthday);
            mpError.put("returnAddress", address);
            mpError.put("returnPostCode", postCode);
            mpError.put("returnCity", city);
            mpError.put("returnAccount", account);
            mpError.put("returnNationality", nationality);
            mpError.put("returnPhone", phone);
            mpError.put("returnDocumentType", documentType);
            mpError.put("returnDocumentNumber", documentNumber);
            mpError.put("returnNif", nif);
            mpError.put("returnPatientNumber", patientNumber);
            mpError.put("returnUsername", username);
            mpError.put("returnEmail", email);
            mpError.put("returnPassword", password);

            return "add-patient";
        }
        // Add user to database
        userService.addUser(user);

        return "redirect:/main";
    }
}
