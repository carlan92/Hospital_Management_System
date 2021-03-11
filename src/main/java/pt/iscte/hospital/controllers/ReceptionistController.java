package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.services.*;
import pt.iscte.hospital.services.validation.SpecialityValidationService;
import pt.iscte.hospital.services.validation.UserValidationService;

import java.util.List;

@Controller
public class ReceptionistController {
    // Attributes
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private NationalityService nationalityService;
    @Autowired
    private SpecialityValidationService specialityValidationService;
    @Autowired
    private UserValidationService userValidationService;
    @Autowired
    private RegistrationService registrationService;

    // Constructor


    // Methods
    @GetMapping(value = "/receptionist/main")
    public String showReceptionistMain(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "receptionist/main";
    }


    @GetMapping(value = "/receptionist/waiting-list")
    public String showWaitingList(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "receptionist/waiting-list";
    }


    @GetMapping(value = "/receptionist/add-speciality")
    public String addSpecialityPage(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "receptionist/add-speciality";
    }

    @PostMapping(value = "/receptionist/add-speciality")
    public String addSpecialityService(@RequestParam String name_speciality, ModelMap mpError) {

        Speciality speciality = new Speciality(name_speciality);

        // Check if speciality is valid
        specialityValidationService.clear().setSpeciality(speciality)
                .validName()
                .validLength();

        if (!specialityValidationService.isValid()) {
            mpError.addAllAttributes(specialityValidationService.getErrorModelMap());
            return "receptionist/add-speciality";
        }

        specialityService.addSpeciality(speciality);

        return ("redirect:/receptionist/main");
    }

    @GetMapping(value = "/receptionist/add-user")
    public String addUserPage(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("nationalities", nationalities);
        modelMap.put("specialities", specialities);

        modelMap.put("user_logged", userLogged);
        return "receptionist/add-user";
    }

    @PostMapping(value = "/receptionist/add-user")
    public String addUser(@ModelAttribute Doctor doctor,
                          @ModelAttribute Patient patient,
                          @ModelAttribute Receptionist receptionist,
                          ModelMap mpError,
                          @RequestParam String confirmarPassword2,
                          @RequestParam String account,
                          @RequestParam(required = false, name = "specialityName") String specialityName) {

        User userLogged = userService.currentUser();
        List<Nationality> nationalities = nationalityService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        mpError.put("user_logged", userLogged);
        mpError.put("nationalities", nationalities);
        mpError.put("specialities", specialities);
        mpError.put("specialityName",specialityName);
        mpError.put("account",account);

        if(account.equals("Médico")) {
           mpError.put("medicalCondition", true);
        } else{
            mpError.put("medicalCondition", false);
        }

        //add doctor account
        if (doctor.getAccount().equals("Médico")) {
            valitationAddAccount(doctor, confirmarPassword2);
            userValidationService.setUser(doctor).validLicenseNumber();
            userValidationService.setUser(doctor).validSpeciality(specialityName);

            if (!userValidationService.isValid()) {
                mpError.addAllAttributes(userValidationService.getErrorModelMap());
                mpError.put("user", doctor);

                return "receptionist/add-user";
            }
            // Add user to database
            registrationService.encryptPassword(doctor);
            Speciality speciality = specialityService.findByName(specialityName);
            doctor.setSpeciality(speciality);
            userService.addUser(doctor);
        }
        //add patient account
        if (patient.getAccount().equals("Utente")) {
            valitationAddAccount(patient, confirmarPassword2);
            if (!userValidationService.isValid()) {
                mpError.addAllAttributes(userValidationService.getErrorModelMap());
                mpError.put("user", patient);

                return "receptionist/add-user";
            }
            // Add user to database
            registrationService.encryptPassword(patient);
            userService.addUser(patient);
        }
        //add recepcionist account
        if (receptionist.getAccount().equals("Recepcionista")) {
            valitationAddAccount(receptionist, confirmarPassword2);
            if (!userValidationService.isValid()) {
                mpError.addAllAttributes(userValidationService.getErrorModelMap());
                mpError.put("user", receptionist);

                return "receptionist/add-user";
            }
            // Add user to database
            registrationService.encryptPassword(receptionist);
            userService.addUser(receptionist);
        }

        return "redirect:/receptionist/main";
    }


    @PostMapping(value = "/receptionist/imprimir")
    public String doImprimir(@ModelAttribute Doctor user, @ModelAttribute Patient patient, @ModelAttribute Receptionist receptionist, @RequestParam String account, @RequestParam (required = false, name = "specialityName")String specialityName, ModelMap modelMap) {

        List<Nationality> nationalities = nationalityService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();
        modelMap.put("user_logged", userLogged);
        modelMap.put("nationalities", nationalities);
        modelMap.put("specialities", specialities);
        modelMap.put("specialityName",specialityName);
        modelMap.put("account",account);

        if(account.equals("Médico")) {
            modelMap.put("medicalCondition", true);
        } else{
            modelMap.put("medicalCondition", false);
        }

        modelMap.put("user_logged", userLogged);
        if (user.getAccount().equals("Médico")) {
            modelMap.put("user", user);
        } else if (patient.getAccount().equals("Utente")) {
            modelMap.put("user", patient);
        } else if (receptionist.getAccount().equals("Recepcionista")) {
            modelMap.put("user", receptionist);
        }
        return "receptionist/add-user";
    }

    @GetMapping(value = "/receptionist/invoice-form")
    public String showInvoiceForm(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "receptionist/invoice-form";
    }

    public void valitationAddAccount(User user, String confirmarPassword2) {
        userValidationService.clear().setUser(user)
                .validName()
                .validPassword()
                .samePassword(confirmarPassword2)
                .validPhone()
                .validPostCode()
                .validSex()
                .validEmail()
                .validEmail2()
                .validUsername()
                .validDocumentType()
                .validDocumentNumber()
                .validDocumentNumberUnique()
                .validPatientNumber()
                .validPatientNumberUnique()
                .validNif()
                .validNifUnique()
                .validCity()
                .validAccount()
                .validBirthday()
                .validNationality()
                .validAddress();

        //add default image.
        if (user.getSex().equals("Masculino")) {
            user.setPhotoURL("user-male.jpg");
        } else {
            user.setPhotoURL("user-female.jpg");
        }
    }
}
