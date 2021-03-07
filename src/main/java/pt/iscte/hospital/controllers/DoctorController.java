package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.DoctorService;
import pt.iscte.hospital.services.PatientService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = {"/doctor/main", "/doctor"})
    public String showDoctorMain(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "doctor/main";
    }

    @GetMapping(value = "/doctor/patient-list")
    public String showPatientList(ModelMap modelMap) {
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "doctor/patient-list";
    }

    @GetMapping(value = "/doctor/doctor-list")
    public String showDoctorList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "doctor/doctor-list";
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
        return "doctor/doctor-list";
    }

    @GetMapping(value = "/doctor/appointment-list")
    public String showAppointmentList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "doctor/appointment-list";
    }

    @GetMapping(value = "/doctor/waiting-list")
    public String showWaitingList(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "doctor/waiting-list";
    }

    @GetMapping(value = "/doctor/appointment-notes")
    public String showAppointmentNotes(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "doctor/appointment-notes";
    }
}
