package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    private static final String errorMsgName = "Já existe essa especialidade";

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
    public String addSpecialityService(@RequestParam String name_speciality, ModelMap mpError){

        Speciality speciality = new Speciality(name_speciality);
        if(!specialityService.validSpeciality(speciality)){
            mpError.put("errorMsgName",errorMsgName);
            return "add-speciality";
        }
        specialityService.addSpeciality(speciality);

        return ("redirect:/main");
    }
}
