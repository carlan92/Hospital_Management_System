package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.PatientService;
import pt.iscte.hospital.services.UserService;

import java.util.List;

@Controller
public class DoctorReceptionistController {

    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/doctor-receptionist/patient-list")
    public String showPatientList(ModelMap modelMap) {
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "doctor-receptionist/patient-list";
    }

    @GetMapping(value = "/doctor-receptionist/patient-profile")
    public String showPatientProfile(ModelMap modelMap) {
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "doctor-receptionist/patient-profile";
    }

    @PostMapping(value = "/search-patients")
    public String searchDoctors(@RequestParam(name = "name") String name,
                                ModelMap modelMap) {
        List<Patient> patients;
        if (name == null || name.isEmpty()) {
            name = "";
            patients = patientService.findAllByFirstAndLastName(name);
        } else {
            patients = patientService.findAllByFirstAndLastName(name);
        }

        User userLogged = userService.currentUser();

        modelMap.put("search_name", name);
        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "doctor-receptionist/patient-list";
    }
}
