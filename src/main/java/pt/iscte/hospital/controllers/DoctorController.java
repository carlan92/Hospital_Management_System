package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
