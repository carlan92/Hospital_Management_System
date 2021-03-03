package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.security.IAuthenticationFacade;
import pt.iscte.hospital.services.DoctorService;
import pt.iscte.hospital.services.PatientService;
import pt.iscte.hospital.services.SpecialityService;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    SpecialityService specialityService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping(value = "/test")
    public String pageTest(ModelMap modelMap) {


        System.out.println("User : " + authenticationFacade.getAuthentication().getName());
        User userLogged = Login.getConnectedUser();

        modelMap.put("user_logged", userLogged);
        return "test";
    }

    @GetMapping(value = "/faturaForm")
    public String pageFaturaForm(ModelMap modelMap) {
        User userLogged = Login.getConnectedUser();

        modelMap.put("user_logged", userLogged);
        return "faturaForm";
    }

    @GetMapping(value = "/historicoPagamentos")
    public String page(ModelMap modelMap) {
        User userLogged = Login.getConnectedUser();

        modelMap.put("user_logged", userLogged);
        return "historicoPagamentos";
    }

    @GetMapping(value = "/lista-utentes")
    public String showListaUtentes(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "lista-utentes";
    }

    @GetMapping(value = "/doctor-consultas")
    public String showDoctorConsultas(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "doctor-consultas";
    }

    @GetMapping(value = "/lista-medicos")
    public String showListaMedicos(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "lista-medicos";
    }

    @GetMapping(value = "/info-appointment")
    public String showInfoConsulta(ModelMap modelMap) {
        User userLogged = Login.getConnectedUser();

        modelMap.put("user_logged", userLogged);
        return "info-appointment";
    }

    @GetMapping(value = "/patient-inicio")
    public String showPatientInicio(ModelMap modelMap) {
        User userLogged = Login.getConnectedUser();

        modelMap.put("user_logged", userLogged);
        return "patient-inicio";
    }
}
