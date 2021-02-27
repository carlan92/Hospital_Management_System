package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.services.SpecialityService;

@Controller
public class PatientController {
    // Attributes

    // Constructor

    // Methods
    @GetMapping(value = "/make-appointment")
    public String makeAppointmentPage() {
        return "make-appointment";
    }


    @PostMapping(value = "/add-speciality")
    public String makeAppointmentService() {
        // TODO lógica
        // envio de dados para a página
        // alterar a página para receber dados
        return ("redirect:/main");
    }

}
