package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.services.*;

import java.util.Date;
import java.util.List;

@Controller
public class ReceptionistController {
    // Attributes
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private NationalityService nationalityService;


    private static final String errorMsgSpeciality = "Já existe essa especialidade";
    private static final String errorMsgLenght="Nome de especialidade demasiado curto";
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

    // Constructor

    // Methods
    @GetMapping(value = "/receptionist/main")
    public String showReceptionistMain(ModelMap modelMap){
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "receptionist/main";
    }

    @GetMapping(value = "/receptionist/patient-list")
    public String showPatientList(ModelMap modelMap) {
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "receptionist/patient-list";
    }

    @GetMapping(value = "/receptionist/doctor-list")
    public String showDoctorList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "receptionist/doctor-list";
    }

    @GetMapping(value = "/receptionist/appointment-list")
    public String showAppointmentList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "receptionist/appointment-list";
    }

    @GetMapping(value = "/receptionist/waiting-list")
    public String showWaitingList(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "receptionist/waiting-list";
    }


    @GetMapping(value = "/receptionist/add-speciality")
    public String addSpecialityPage(ModelMap modelMap){
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return ("receptionist/add-speciality");
    }

    @PostMapping(value = "/receptionist/add-speciality")
    public String addSpecialityService(@RequestParam String name_speciality, ModelMap mpError){

        Speciality speciality = new Speciality(name_speciality);

        if(!specialityService.validSpeciality(speciality)){
            mpError.put("errorMsgSpeciality", errorMsgSpeciality);
            return "receptionist/add-speciality";
        }
        if(!specialityService.validLength(speciality)){
            mpError.put("errorMsgSpeciality", errorMsgLenght);
            return "receptionist/add-speciality";
        }

        specialityService.addSpeciality(speciality);

        return ("redirect:/receptionist/main");
    }

    @GetMapping(value = "/receptionist/add-patient")
    public String addPatientPage(ModelMap modelMap){
        List<Nationality> nationalities = nationalityService.findAll();
        User userLogged = userService.currentUser();

        modelMap.put("nationalities", nationalities);
        modelMap.put("user_logged", userLogged);
        return ("receptionist/add-patient");
    }

    @PostMapping(value = "/receptionist/add-patient")
    public String addPatient(@ModelAttribute Patient user,
                             ModelMap mpError,
                             @RequestParam String confirmarPassword2){

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
        if(!registrationService.validDocumentNumberUnique(user)){
            mpError.put("errorMsgDocumentNumber", errorMsgDocumentNumber2);
            isFormValid =false;
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
        //add default image.
        if(user.getSex().equals("Masculino")){
            user.setPhotoURL("user-male.jpg");
        } else{
            user.setPhotoURL("user-female.jpg");
        }

        if (!isFormValid) {

            mpError.put("user", user);

            return "receptionist/add-patient";
        }
        // Add user to database
        userService.addUser(user);

        return "redirect:/receptionist/main";
    }

    @GetMapping(value = "/receptionist/add-doctor")
    public String addDoctorPage(ModelMap modelMap){
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return ("receptionist/add-doctor");
    }


    @PostMapping (value ="/receptionist/imprimir")
    public String doImprimir(@ModelAttribute Patient user, ModelMap modelMap){

        modelMap.put("user", user);
        return ("receptionist/add-patient");
    }
}
