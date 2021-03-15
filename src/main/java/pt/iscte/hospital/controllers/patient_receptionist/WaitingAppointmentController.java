package pt.iscte.hospital.controllers.patient_receptionist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.user.DoctorService;
import pt.iscte.hospital.services.user.UserService;
import pt.iscte.hospital.services.waiting.PatientWaitingAppointmentService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class WaitingAppointmentController {
    private static final String PATIENT_TYPE_URL = "/patient/waitingAppointment";
    private static final String RECEPTIONIST_TYPE_URL = "/receptionist/waitingAppointment";
    private static final String USER_TYPE_URL = "patient-receptionist/waitingAppointment";

    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientWaitingAppointmentService patientWaitingAppointmentService;

    @GetMapping(value = "patient/waitingAppointment")
    public String showPatientWaitingAppointmentList(ModelMap modelMap) {
        List<PatientWaitingAppointment> patientWaitingAppointments = new ArrayList<>();
        patientWaitingAppointments=patientWaitingAppointmentService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();



        modelMap.addAllAttributes(appointmentListView(
                patientWaitingAppointments,
                userLogged,
                PATIENT_TYPE_URL,
                null));

        return USER_TYPE_URL;
    }

    //marcar pedido de lista de espera
    @PostMapping(value = "patient/waitingAppointment")
    public String showMakeApplyForPatientWaitingAppointment(ModelMap modelMap,
                                                     @RequestParam(required = false, name = "specialityName") String specialityName,
                                                     @RequestParam(required = false, name = "doctorId") String doctorId) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Speciality speciality = specialityService.findByName(specialityName);

        User userLogged = userService.currentUser();

        List<Doctor> doctors = doctorService.findAllBySpecialityOrderByNameAsc(speciality);
        List<PatientWaitingAppointment> patientWaitingAppointments = new ArrayList<>();
        patientWaitingAppointments=patientWaitingAppointmentService.findAll();

        modelMap.put("doctors", doctors);
        modelMap.put("search_speciality", specialityName);
        modelMap.put("search_doctor", doctorId);

        modelMap.addAllAttributes(appointmentListView(
                patientWaitingAppointments,
                userLogged,
                PATIENT_TYPE_URL,
                specialityName));

        return USER_TYPE_URL;
    }
    @GetMapping(value = "receptionist/waitingAppointment")
    public String showReceptionistWaitingAppointmentList(ModelMap modelMap) {
        List<PatientWaitingAppointment> patientWaitingAppointments = new ArrayList<>();
        patientWaitingAppointments=patientWaitingAppointmentService.findAll();
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();



        modelMap.addAllAttributes(appointmentListView(
                patientWaitingAppointments,
                userLogged,
                RECEPTIONIST_TYPE_URL,
                null));

        return USER_TYPE_URL;
    }

    //marcar pedido de lista de espera
    @PostMapping(value = "receptionist/waitingAppointment")
    public String showMakeApplyForReceptionistWaitingAppointment(ModelMap modelMap,
                                                     @RequestParam(required = false, name = "specialityName") String specialityName,
                                                     @RequestParam(required = false, name = "doctorId") String doctorId) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Speciality speciality = specialityService.findByName(specialityName);

        User userLogged = userService.currentUser();

        List<Doctor> doctors = doctorService.findAllBySpecialityOrderByNameAsc(speciality);
        List<PatientWaitingAppointment> patientWaitingAppointments = new ArrayList<>();
        patientWaitingAppointments=patientWaitingAppointmentService.findAll();

        modelMap.put("doctors", doctors);
        modelMap.put("search_speciality", specialityName);
        modelMap.put("search_doctor", doctorId);

        modelMap.addAllAttributes(appointmentListView(
                patientWaitingAppointments,
                userLogged,
                RECEPTIONIST_TYPE_URL,
                specialityName));

        return USER_TYPE_URL;
    }

    //private Methods

    private ModelMap appointmentListView(List<PatientWaitingAppointment> patientWaitingAppointments,
                                         User userLogged,
                                         String userTypeURL,
                                         String specialityName) {
        ModelMap modelMap = new ModelMap();

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.put("specialities", specialities);
        modelMap.put("patientWaitingAppointments", patientWaitingAppointments);
        modelMap.put("user_logged", userLogged);
        modelMap.put("userTypeURL", userTypeURL);
        modelMap.put("specialityName", specialityName);
        return modelMap;
    }

    private List<PatientWaitingAppointment> filterWaitingAppointments(List<PatientWaitingAppointment> waitingAppointments,
                                                                      LocalDateTime date,
                                                                      String patientName,
                                                                      String specialityName,
                                                                      String doctorName) {
        List<PatientWaitingAppointment> result = waitingAppointments;
        // Filter by date
        if (date != null) {
            Set<PatientWaitingAppointment> tempList = new HashSet<>();
            for (PatientWaitingAppointment waitingAppointment : result) {
                if (waitingAppointment.getDate().equals(date)) {
                    tempList.add(waitingAppointment);
                }
            }
            result.clear();
            result.addAll(tempList);
        }

        // Filter by Patient Name
        if (patientName != null && !patientName.isEmpty()) {
            Set<PatientWaitingAppointment> tempList = new HashSet<>();
            String[] patientNamesSearch = patientName.split(" ");
            for (String nameSearch : patientNamesSearch) {
                for (PatientWaitingAppointment patientWaitingAppointment : result) {
                    if (patientWaitingAppointment.getPatient().getFirstAndLastName().toLowerCase().contains(nameSearch.toLowerCase())) {
                        tempList.add(patientWaitingAppointment);
                    }
                }
            }
            result.clear();
            result.addAll(tempList);
        }

        // Filter by Speciality
        if (specialityName != null && !specialityName.isEmpty()) {
            Set<PatientWaitingAppointment> tempList = new HashSet<>();
            for (PatientWaitingAppointment patientWaitingAppointment : result) {
                if (patientWaitingAppointment
                        .getDoctor()
                        .getSpeciality()
                        .getName().equals(specialityName)) {
                    tempList.add(patientWaitingAppointment);
                }
            }
            result.clear();
            result.addAll(tempList);
        }

        // Doctor Name
        if (doctorName != null && !doctorName.isEmpty()) {
            Set<PatientWaitingAppointment> tempList = new HashSet<>();
            String[] doctorNamesSearch = doctorName.split(" ");
            for (String nameSearch : doctorNamesSearch) {
                for (PatientWaitingAppointment patientWaitingAppointment : result) {
                    if (patientWaitingAppointment.getDoctor().getFirstAndLastName().toLowerCase().contains(nameSearch.toLowerCase())) {
                        tempList.add(patientWaitingAppointment);
                    }
                }
            }
            result.clear();
            result.addAll(tempList);
        }
        return result;
    }
}
