package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.security.IAuthenticationFacade;
import pt.iscte.hospital.services.DoctorService;
import pt.iscte.hospital.services.PatientService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/test")
    public String pageTest(ModelMap modelMap) {


        System.out.println("User : " + authenticationFacade.getAuthentication().getName());
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "test";
    }

    @GetMapping(value = "/faturaForm")
    public String pageFaturaForm(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "faturaForm";
    }

    @GetMapping(value = "/historicoPagamentos")
    public String page(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "historicoPagamentos";
    }

    @GetMapping(value = "/lista_medicos_doctor_patient")
    public String showListaMedicostoDoctorandPatient(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "lista_medicos_doctor_patient";
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
        return "lista_medicos_doctor_patient";
    }


}
