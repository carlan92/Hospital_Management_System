package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.User;

@Controller
public class PatientController {
    // Attributes

    // Constructor

    // Methods
    @GetMapping(value = "/make-appointment")
    public String makeAppointmentPage(ModelMap modelMap) {
        User userLogged = Login.getConnectedUser();
        modelMap.put("user_logged", userLogged);
        return "make-appointment";
    }


    @PostMapping(value = "/make-appointment")
    public String makeAppointmentService() {
        // TODO lógica
        // envio de dados para a página
        // alterar a página para receber dados
        return ("redirect:/main");
    }

}
