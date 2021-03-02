package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.repositories.DoctorRepository;
import pt.iscte.hospital.repositories.PatientRepository;
import pt.iscte.hospital.repositories.SpecialityRepository;

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
    public String pageTest() {
        return "test";
    }

    @GetMapping(value = "/faturaForm")
    public String pageFaturaForm() {
        return "faturaForm";
    }

    @GetMapping(value = "/historicoPagamentos")
    public String page() {
        return "historicoPagamentos";
    }

    @GetMapping(value = "/lista-utentes")
    public String showListaUtentes(ModelMap modelMap) {
        List<Speciality> specialities = specialityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));  // TODO trocar por serviços
        List<Patient> patients = patientRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));            // TODO trocar por serviços

        modelMap.put("specialities", specialities);
        modelMap.put("patients", patients);
        return "lista-utentes";
    }

    @GetMapping(value = "/doctor-consultas")
    public String showDoctorConsultas(ModelMap modelMap) {
        List<Speciality> specialities = specialityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        modelMap.put("specialities", specialities);
        return "doctor-consultas";
    }

    @GetMapping(value = "/lista-medicos")
    public String showListaMedicos(ModelMap modelMap) {
        List<Speciality> specialities = specialityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        return "lista-medicos";
    }

    @GetMapping(value = "/info-appointment")
    public String showInfoConsulta(ModelMap modelMap) {
        return "info-appointment";
    }

    @GetMapping(value = "/patient-inicio")
    public String showPatientInicio(ModelMap modelMap) {
        return "patient-inicio";
    }
}
