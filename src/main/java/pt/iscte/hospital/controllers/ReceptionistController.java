package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.services.SpecialityService;

@Controller
public class ReceptionistController {
    // Attributes
    @Autowired
    SpecialityService specialityService;

    // Constructor

    // Methods
    @GetMapping(value = "/add-speciality")
    public String addSpecialityPage(){
        return ("add-speciality");
    }

    @GetMapping(value = "/add-patient")
    public String addPatientPage(){
        return ("add-patient");
    }

    @PostMapping(value = "/add-speciality")
    public String addSpecialityService(@RequestParam String name_speciality){
        // TODO lógica de adicionar especialidade...
        Speciality speciality = new Speciality(name_speciality);
        specialityService.addSpeciality(speciality);

        return ("redirect:/main");
    }
}
