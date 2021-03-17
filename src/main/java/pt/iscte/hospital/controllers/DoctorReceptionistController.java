package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.controllers.utils.Common;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.services.user.PatientService;

import java.util.List;

@Controller
public class DoctorReceptionistController {

    private final PatientService patientService;
    private final Common common;

    @Autowired
    public DoctorReceptionistController(PatientService patientService, Common common) {
        this.patientService = patientService;
        this.common = common;
    }

    @GetMapping(value = "/doctor-receptionist/patient-list")
    public String showPatientList(ModelMap modelMap) {
        List<Patient> patients = patientService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.put("patients", patients);
        modelMap.addAllAttributes(common.sideNavMap());
        return "doctor-receptionist/patient-list";
    }

    @GetMapping(value = "/doctor-receptionist/patient-profile/{patientId}")
    public String showPatientProfile(ModelMap modelMap, @PathVariable(value = "patientId") Long patientId) {
        Patient patient = patientService.findByUserId(patientId);

        modelMap.addAllAttributes(common.sideNavMap());
        modelMap.put("patient", patient);
        return "doctor-receptionist/patient-profile";
    }

    @PostMapping(value = "/search-patients")
    public String searchDoctors(@RequestParam(name = "name") String name,
                                ModelMap modelMap) {
        List<Patient> patients;
        if (name == null || name.isEmpty()) {
            name = "";
        }
        patients = patientService.findAllByFirstAndLastName(name);

        modelMap.put("search_name", name);
        modelMap.put("patients", patients);
        modelMap.addAllAttributes(common.sideNavMap());
        return "doctor-receptionist/patient-list";
    }
}
