package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;

    // Attributes

    // Constructor

    // Methods
    @GetMapping(value = "/patient/main")
    public String showPatientMain(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "patient/main";
    }

    @GetMapping(value = "/patient/appointment-list")
    public String showAppointmentList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "patient/appointment-list";
    }

    @GetMapping(value = "/patient/make-appointment")
    public String showMakeAppointment(ModelMap modelMap) {
        User userLogged = userService.currentUser();
        modelMap.put("user_logged", userLogged);
        return "patient/make-appointment";
    }


    @PostMapping(value = "/patient/make-appointment")
    public String makeAppointmentService() {
        // TODO lógica
        // envio de dados para a página
        // alterar a página para receber dados
        return ("redirect:/patient/main");
    }

}
