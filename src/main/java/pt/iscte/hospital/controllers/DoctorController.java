package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.repositories.AppointmentRepository;
import pt.iscte.hospital.services.user.DoctorService;
import pt.iscte.hospital.services.user.PatientService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.user.UserService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = {"/doctor/main", "/doctor"})
    public String showDoctorMain(ModelMap modelMap) {
        LocalDate dateToday = LocalDate.now();

        List<Appointment> todayCheckedInAppointments = appointmentRepository.findAllBySlotDoctorUserIdAndSlotDateAndHasCheckedOrderBySlotTimeBeginAsc(
                currentUser().getUserId(),
                dateToday,
                true
        );

        List<Appointment> todayOngoingAppointments = appointmentRepository.findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusOrderBySlotTimeBeginAsc(
                currentUser().getUserId(),
                dateToday,
                AppointmentState.EM_CURSO.getStateNr()
        );

        modelMap.put("todayCheckedInAppointments", todayCheckedInAppointments);
        modelMap.put("todayOngoingAppointments", todayOngoingAppointments);
        modelMap.put("user_logged", currentUser());
        return "doctor/main";
    }


    @GetMapping(value = "/doctor/waiting-list")
    public String showWaitingList(ModelMap modelMap) {
        modelMap.put("user_logged", currentUser());
        return "doctor/waiting-list";
    }

    @GetMapping(value = "/doctor/appointment-notes")
    public String showAppointmentNotes(ModelMap modelMap) {
        modelMap.put("user_logged", currentUser());
        return "doctor/appointment-notes";
    }

    private User currentUser(){
        return userService.currentUser();
    }
}
