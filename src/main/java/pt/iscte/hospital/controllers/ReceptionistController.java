package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.controllers.utils.Common;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.services.*;
import pt.iscte.hospital.services.user.UserService;
import pt.iscte.hospital.services.validation.SpecialityValidationService;
import pt.iscte.hospital.services.validation.UserValidationService;

import java.time.LocalDate;
import java.util.List;

import static pt.iscte.hospital.entities.states.AppointmentState.MARCADA;

@Controller
public class ReceptionistController {
    // Attributes
    private final SpecialityService specialityService;
    private final UserService userService;
    private final NationalityService nationalityService;
    private final AppointmentService appointmentService;
    private final SpecialityValidationService specialityValidationService;
    private final UserValidationService userValidationService;
    private final RegistrationService registrationService;
    private final Common common;

    // Constructor
    @Autowired
    public ReceptionistController(SpecialityService specialityService,
                                  UserService userService,
                                  NationalityService nationalityService,
                                  AppointmentService appointmentService,
                                  SpecialityValidationService specialityValidationService,
                                  UserValidationService userValidationService,
                                  RegistrationService registrationService,
                                  Common common) {
        this.specialityService = specialityService;
        this.userService = userService;
        this.nationalityService = nationalityService;
        this.appointmentService = appointmentService;
        this.specialityValidationService = specialityValidationService;
        this.userValidationService = userValidationService;
        this.registrationService = registrationService;
        this.common = common;
    }


    // Methods
    @GetMapping(value = "/receptionist/main")
    public String showReceptionistMain(ModelMap modelMap) {
        modelMap.addAllAttributes(common.sideNavMap());
        return "receptionist/main";
    }

    //TODO confirmar página lista de espera para consulta para o dia de hoje
    @GetMapping(value = "/receptionist/waiting-list")
    public String showWaitingList(ModelMap modelMap) {
        LocalDate date = LocalDate.now();

        List<Appointment> appointments = appointmentService.findAllBySlotDateAndAppointmentStatus(
                date,
                MARCADA.getStateNr());

        appointments.sort(null);

        modelMap.addAllAttributes(common.sideNavMap());
        modelMap.put("appointments", appointments);
        return "receptionist/waiting-list";
    }


    @GetMapping(value = "/receptionist/add-speciality")
    public String addSpecialityPage(ModelMap modelMap) {
        modelMap.addAllAttributes(common.sideNavMap());
        return "receptionist/add-speciality";
    }

    @PostMapping(value = "/receptionist/add-speciality")
    public String addSpecialityService(@RequestParam String name_speciality, @RequestParam double price, ModelMap mpError) {

        Speciality speciality = new Speciality(name_speciality, price);

        // Check if speciality is valid
        specialityValidationService.clear().setSpeciality(speciality)
                .validName()
                .validLength();

        if (!specialityValidationService.isValid()) {
            mpError.addAllAttributes(specialityValidationService.getErrorModelMap());
            return "receptionist/add-speciality";
        }
//TODO falta validação do preço
        specialityService.addSpeciality(speciality);

        return ("redirect:/receptionist/main");
    }

    @GetMapping(value = "/receptionist/add-user")
    public String addUserPage(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.put("nationalities", nationalities);
        modelMap.put("specialities", specialities);
        modelMap.addAllAttributes(common.sideNavMap());
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
        List<Nationality> nationalities = nationalityService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        mpError.addAllAttributes(common.sideNavMap());
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
        modelMap.addAllAttributes(common.sideNavMap());
        modelMap.put("nationalities", nationalities);
        modelMap.put("specialities", specialities);
        modelMap.put("specialityName",specialityName);
        modelMap.put("account",account);

        if(account.equals("Médico")) {
            modelMap.put("medicalCondition", true);
        } else{
            modelMap.put("medicalCondition", false);
        }

        modelMap.addAllAttributes(common.sideNavMap());
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
