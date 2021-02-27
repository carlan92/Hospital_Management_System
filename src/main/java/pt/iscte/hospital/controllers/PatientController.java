package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {
    // Attributes

    // Constructor

    // Methods
    @GetMapping(value = "/make-appointment")
    public String makeAppointmentPage() {
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
