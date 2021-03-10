package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.repositories.AppointmentRepository;
import pt.iscte.hospital.services.*;

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
        List<Speciality> specialities=specialityService.findAll(Sort.by(Sort.Direction.ASC,"name"));

        modelMap.put("nationalities", nationalities);
        modelMap.put("specialities",specialities);

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
        User connectedUser = userService.currentUser();
        if (userService.currentUser().getAccount().equals("Utente")) {
            userValidationService.clear().setUser(patient)
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

            if (!patient.getDocumentNumber().equals(connectedUser.getDocumentNumber())) {
                userValidationService.validDocumentNumberUnique();
            }
            if (patient.getPatientNumber() != null) {
                if (!patient.getPatientNumber().equals(connectedUser.getPatientNumber())) {
                    userValidationService.validPatientNumberUnique();
                }
            }

            if (!patient.getNif().equals(connectedUser.getNif())) {
                userValidationService.validNifUnique();
            }

            if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
                try {
                    String photoURL = imageUploadService.uploadImage(file, userService.currentUser().getUsername());
                    patient.setPhotoURL(photoURL);
                } catch (IOException e) {
                    userValidationService.notValidPhotoUpload();
                } catch (ImageTypeException e) {
                    userValidationService.notValidImageType();
                } catch (ImageSizeException e) {
                    userValidationService.notValidImageSize();
                }
            } else {
                patient.setPhotoURL(userService.currentUser().getPhotoURL());
            }

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
        } else if (userService.currentUser().getAccount().equals("Médico")) {
            userValidationService.clear().setUser(doctor)
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

            if (!doctor.getDocumentNumber().equals(connectedUser.getDocumentNumber())) {
                userValidationService.validDocumentNumberUnique();
            }
            if (doctor.getPatientNumber() != null) {
                if (!doctor.getPatientNumber().equals(connectedUser.getPatientNumber())) {
                    userValidationService.validPatientNumberUnique();
                }
            }

            if (!doctor.getNif().equals(connectedUser.getNif())) {
                userValidationService.validNifUnique();
            }

            if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
                try {
                    String photoURL = imageUploadService.uploadImage(file, userService.currentUser().getUsername());
                    doctor.setPhotoURL(photoURL);
                } catch (IOException e) {
                    userValidationService.notValidPhotoUpload();
                } catch (ImageTypeException e) {
                    userValidationService.notValidImageType();
                } catch (ImageSizeException e) {
                    userValidationService.notValidImageSize();
                }
            } else {
                doctor.setPhotoURL(userService.currentUser().getPhotoURL());
            }

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
            Speciality speciality = specialityService.findByName(((Doctor)connectedUser).getSpeciality().getName());
            doctor.setSpeciality(speciality);

            userService.addUser(doctor);

        } else if (userService.currentUser().getAccount().equals("Recepcionista")) {
            userValidationService.clear().setUser(receptionist)
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

            if (!receptionist.getDocumentNumber().equals(connectedUser.getDocumentNumber())) {
                userValidationService.validDocumentNumberUnique();
            }
            if (receptionist.getPatientNumber() != null) {
                if (!receptionist.getPatientNumber().equals(connectedUser.getPatientNumber())) {
                    userValidationService.validPatientNumberUnique();
                }
            }

            if (!receptionist.getNif().equals(connectedUser.getNif())) {
                userValidationService.validNifUnique();
            }

            if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
                try {
                    String photoURL = imageUploadService.uploadImage(file, userService.currentUser().getUsername());
                    receptionist.setPhotoURL(photoURL);
                } catch (IOException e) {
                    userValidationService.notValidPhotoUpload();
                } catch (ImageTypeException e) {
                    userValidationService.notValidImageType();
                } catch (ImageSizeException e) {
                    userValidationService.notValidImageSize();
                }
            } else {
                receptionist.setPhotoURL(userService.currentUser().getPhotoURL());
            }

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

    @GetMapping(value = "/user/appointment-details")
    public String showAppointmentDetails(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();
        Patient patient = patientService.findByUserId(userLogged.getUserId());
        List<Appointment> appointments = appointmentRepository.findAllByPatientAndAppointmentStatus(patient, AppointmentState.MARCADA.getStateNr());

        modelMap.put("specialities", specialities);
        modelMap.put("appointments", appointments);
        modelMap.put("user_logged", userLogged);
        return "user/appointment-details";
    }

    /*@GetMapping(value = "/user/appointment-list")
    public String showAppointmentList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();
        Patient patient = patientService.findByUserId(userLogged.getUserId());
        List<Appointment> appointments = appointmentRepository.findAllByPatientAndAppointmentStatus(patient, AppointmentState.MARCADA.getStateNr());
        appointments.sort(null);

        modelMap.put("specialities", specialities);
        modelMap.put("appointments", appointments);
        modelMap.put("user_logged", userLogged);
        return "user/appointment-list";
    }
*/

}
