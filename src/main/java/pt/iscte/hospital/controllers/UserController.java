package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.repositories.AppointmentRepository;
import pt.iscte.hospital.services.*;

import pt.iscte.hospital.services.user.DoctorService;
import pt.iscte.hospital.services.user.PatientService;
import pt.iscte.hospital.services.user.UserService;
import pt.iscte.hospital.services.validation.UserValidationService;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private NationalityService nationalityService;
    @Autowired
    private UserValidationService userValidationService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping(value = "/user/change-profile-data")
    public String showChangeProfileData(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.put("nationalities", nationalities);
        modelMap.put("specialities", specialities);

        modelMap.put("user_logged", userService.currentUser());
        modelMap.put("user", userService.currentUser());

        return "user/change-profile-data";
    }

    @PostMapping(value = "/user/change-profile-data")
    public String changeDataPage(@ModelAttribute Patient patient,
                                 @ModelAttribute Doctor doctor,
                                 @ModelAttribute Receptionist receptionist,
                                 ModelMap modelMap,
                                 @RequestParam("file") MultipartFile file) {

        // Update user info
        //utente
        User connectedUser = userService.currentUser();
        if (userService.currentUser().getAccount().equals("Utente")) {
            validation(patient, file);

            if (!userValidationService.isValid()) {
                // case error in info validation
                List<Nationality> nationalities = nationalityService.findAll();
                modelMap.addAllAttributes(userValidationService.getErrorModelMap());
                modelMap.put("nationalities", nationalities);

                modelMap.put("user_logged", userService.currentUser());
                modelMap.put("user", patient);
                return "user/change-profile-data";
            }
            patient.setUserId(connectedUser.getUserId());
            patient.setEmail(connectedUser.getEmail());
            patient.setUsername(connectedUser.getUsername());
            patient.setPassword(connectedUser.getPassword());
            patient.setAccount(connectedUser.getAccount());

            userService.addUser(patient);

            //médico
        } else if (userService.currentUser().getAccount().equals("Médico")) {
            validation(doctor, file);
            userValidationService.setUser(doctor).validLicenseNumber();

            if (!userValidationService.isValid()) {
                // case error in info validation
                List<Nationality> nationalities = nationalityService.findAll();
                modelMap.addAllAttributes(userValidationService.getErrorModelMap());
                modelMap.put("nationalities", nationalities);

                modelMap.put("user_logged", userService.currentUser());
                modelMap.put("user", doctor);
                return "user/change-profile-data";
            }
            doctor.setUserId(connectedUser.getUserId());
            doctor.setEmail(connectedUser.getEmail());
            doctor.setUsername(connectedUser.getUsername());
            doctor.setPassword(connectedUser.getPassword());
            doctor.setAccount(connectedUser.getAccount());
            Speciality speciality = specialityService.findByName(((Doctor) connectedUser).getSpeciality().getName());
            doctor.setSpeciality(speciality);

            userService.addUser(doctor);

            //recepcionista
        } else if (userService.currentUser().getAccount().equals("Recepcionista")) {
            validation(receptionist, file);

            if (!userValidationService.isValid()) {
                // case error in info validation
                List<Nationality> nationalities = nationalityService.findAll();
                modelMap.addAllAttributes(userValidationService.getErrorModelMap());
                modelMap.put("nationalities", nationalities);

                modelMap.put("user_logged", userService.currentUser());
                modelMap.put("user", receptionist);
                return "user/change-profile-data";
            }
            receptionist.setUserId(connectedUser.getUserId());
            receptionist.setEmail(connectedUser.getEmail());
            receptionist.setUsername(connectedUser.getUsername());
            receptionist.setPassword(connectedUser.getPassword());
            receptionist.setAccount(connectedUser.getAccount());

            userService.addUser(receptionist);
        }
        return "redirect:/user/user-profile";
    }

    //change data form
    @GetMapping(value = "/user/user-profile")
    public String showUserProfile(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "user/user-profile";
    }

    @GetMapping(value = "/userToMain")
    public String showMainPage() {
        return "redirect:/";
    }


    @GetMapping(value = "/user/doctor-list")
    public String showDoctorList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "user/doctor-list";
    }

    @PostMapping(value = "/search-doctors")
    public String searchDoctors(@RequestParam(name = "name") String name,
                                @RequestParam(required = false, name = "speciality") String speciality,
                                ModelMap modelMap) {
        List<Doctor> doctors;
        if (speciality == null || speciality.isEmpty()) {
            speciality = "";
            doctors = doctorService.findAllByFirstAndLastName(name);
        } else {
            doctors = doctorService.findAllByFirstAndLastNameAndSpeciality(name, speciality);
        }

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("search_name", name);
        modelMap.put("search_speciality", speciality);
        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "user/doctor-list";
    }

    @GetMapping(value = "/{userType}/appointment-details/{tempo}/{appointmentId}")
    public String showAppointmentDetails(ModelMap modelMap, @PathVariable(value = "userType") String userType, @PathVariable(value = "tempo") String tempo, @PathVariable(value = "appointmentId") Long appointmentId) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();
        Appointment appointment = appointmentService.findByAppointmentId(appointmentId);
        Patient patient = patientService.findByUserId(appointment.getPatient().getUserId());



        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        modelMap.put("patient", patient);
        modelMap.put("appointment", appointment);
        modelMap.put("userType", userType);
        modelMap.put("tempo", tempo);
        return "user/appointment-details";
    }

    public void validation(User user, MultipartFile file) {
        User connectedUser = userService.currentUser();
        userValidationService.clear().setUser(user)
                .validName()
                .validPhone()
                .validPostCode()
                .validSex()
                .validDocumentType()
                .validDocumentNumber()
                .validPatientNumber()
                .validNif()
                .validCity()
                .validBirthday()
                .validNationality()
                .validAddress();

        if (!user.getDocumentNumber().equals(connectedUser.getDocumentNumber())) {
            userValidationService.validDocumentNumberUnique();
        }
        if (user.getPatientNumber() != null) {
            if (!user.getPatientNumber().equals(connectedUser.getPatientNumber())) {
                userValidationService.validPatientNumberUnique();
            }
        }

        if (!user.getNif().equals(connectedUser.getNif())) {
            userValidationService.validNifUnique();
        }

        if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
            try {
                String photoURL = imageUploadService.uploadImage(file, userService.currentUser().getUsername());
                user.setPhotoURL(photoURL);
            } catch (IOException e) {
                userValidationService.notValidPhotoUpload();
            } catch (ImageTypeException e) {
                userValidationService.notValidImageType();
            } catch (ImageSizeException e) {
                userValidationService.notValidImageSize();
            }
        } else {
            user.setPhotoURL(userService.currentUser().getPhotoURL());
        }

    }
}
