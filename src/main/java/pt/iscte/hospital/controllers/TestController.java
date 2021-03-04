package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.*;
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

    @GetMapping(value = "/lista_utentes_recep")
    public String showListaUtentestoRecep(ModelMap modelMap) {
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "lista_utentes_recep";
    }

    @GetMapping(value = "/lista_utentes_doctor")
    public String showListaUtentestoDoctor(ModelMap modelMap) {
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("patients", patients);
        modelMap.put("user_logged", userLogged);
        return "lista_utentes_doctor";
    }


    @GetMapping(value = "/lista_medicos_recep")
    public String showListaMedicostoRecep(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "lista_medicos_recep";
    }

    @GetMapping(value = "/lista_medicos_doctor_patient")
    public String showListaMedicostoDoctorandPatient(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "lista_medicos_doctor_patient";
    }

    @GetMapping(value = "/consultas_doctor")
    public String showConsultastoDoctor(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "consultas_doctor";
    }

    @GetMapping(value = "/consultas_patient")
    public String showConsultastoPatient(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "consultas_patient";
    }

    @GetMapping(value = "/consultas_recep")
    public String showConsultastoRecep(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = Login.getConnectedUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "consultas_recep";
    }

    @GetMapping(value = "/lista_espera_doctor")
    public String showWaitListtoDoctor(ModelMap modelMap) {
        User userLogged = Login.getConnectedUser();

        modelMap.put("user_logged", userLogged);
        return "lista_espera_doctor";
    }

    @GetMapping(value = "/lista_espera_recep")
    public String showWaitListtoRecep(ModelMap modelMap) {
        User userLogged = Login.getConnectedUser();

        modelMap.put("user_logged", userLogged);
        return "lista_espera_recep";
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
