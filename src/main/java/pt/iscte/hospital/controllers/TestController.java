package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.repositories.DoctorRepository;
import pt.iscte.hospital.repositories.PatientRepository;
import pt.iscte.hospital.repositories.SpecialityRepository;
import pt.iscte.hospital.services.DoctorService;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;


    @Autowired
    SpecialityRepository specialityRepository;

    @GetMapping(value = "/test")
    public String pageTest(ModelMap modelMap) {
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
        List<Speciality> specialities = specialityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));  // TODO trocar por serviços
        List<Patient> patients = patientRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));            // TODO trocar por serviços
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "lista-utentes";
    }

    @GetMapping(value = "/doctor-consultas")
    public String showDoctorConsultas(ModelMap modelMap) {
        List<Speciality> specialities = specialityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "doctor-consultas";
    }

    @GetMapping(value = "/lista-medicos")
    public String showListaMedicos(ModelMap modelMap) {
        List<Speciality> specialities = specialityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
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
