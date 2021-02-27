package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReceptionistController {


    @GetMapping(value = "/add-speciality")
    public String addSpecialityPage(){
        return ("add-speciality");
    }

    @PostMapping(value = "/add-speciality")
    public String addSpecialityService(@RequestParam String especialidade){
        // TODO lógica de adicionar especialidade...
        return ("redirect:/main");
    }
}
