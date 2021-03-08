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
    public String addSpecialityPage(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return ("receptionist/add-speciality");
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

    @GetMapping(value = "/receptionist/add-patient")
    public String addPatientPage(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityService.findAll();
        User userLogged = userService.currentUser();

        modelMap.put("nationalities", nationalities);
        modelMap.put("user_logged", userLogged);
        return ("receptionist/add-patient");
    }

    @PostMapping(value = "/receptionist/add-patient")
    public String addPatient(@ModelAttribute Patient user,
                             ModelMap mpError,
                             @RequestParam String confirmarPassword2) {

        List<Nationality> nationalities = nationalityService.findAll();
        mpError.put("nationalities", nationalities);

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

        if (!userValidationService.isValid()) {
            mpError.addAllAttributes(userValidationService.getErrorModelMap());
            mpError.put("user", user);

            return "receptionist/add-patient";
        }
        // Add user to database
        registrationService.encryptPassword(user);
        userService.addUser(user);

        return "redirect:/receptionist/main";
    }

    @GetMapping(value = "/receptionist/add-doctor")
    public String addDoctorPage(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return ("receptionist/add-doctor");
    }


    @PostMapping(value = "/receptionist/imprimir")
    public String doImprimir(@ModelAttribute Patient user, ModelMap modelMap) {

        modelMap.put("user", user);
        return ("receptionist/add-patient");
    }

    @GetMapping(value = "/receptionist/invoice-form")
    public String showInvoiceForm(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "receptionist/invoice-form";
    }
}
