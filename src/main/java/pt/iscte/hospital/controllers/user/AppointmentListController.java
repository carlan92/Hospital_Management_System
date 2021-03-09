package pt.iscte.hospital.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.services.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pt.iscte.hospital.entities.states.AppointmentState.*;

@Controller
public class AppointmentListController {
    // Attributes
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SlotService slotService;


    // Constructor

    // Methods
    //*************************
    @GetMapping(value = {"/patient/appointment-list/current"})
    public String showAppointmentListPatientCurrent(ModelMap modelMap) {
        String userTypeURL = "/patient/appointment-list/current";
        modelMap.put("userTypeURL", userTypeURL);
        List<AppointmentState> appointmentStates = Arrays.asList(MARCADA);

        modelMap.putAll(appointmentListView(appointmentStates));
        return "user/appointment-list";
    }

    @GetMapping(value = {"/patient/appointment-list/past"})
    public String showAppointmentListPatientPast(ModelMap modelMap) {
        String userTypeURL = "/patient/appointment-list/past";
        List<AppointmentState> appointmentStates = Arrays.asList(DESMARCADA_PELO_UTENTE,
                DESMARCADA_PELO_MEDICO,
                REALIZADA,
                NAO_REALIZADA);

        modelMap.put("userTypeURL", userTypeURL);
        modelMap.putAll(appointmentListView(appointmentStates));
        return "user/appointment-list";
    }

    @GetMapping(value = {"/doctor/appointment-list"})
    public String showAppointmentListDoctor(ModelMap modelMap) {
        String userTypeURL = "/doctor/appointment-list";
        modelMap.put("userTypeURL", userTypeURL);
        List<AppointmentState> appointmentStates = Arrays.asList(AppointmentState.values());

        modelMap.putAll(appointmentListView(appointmentStates));
        return "user/appointment-list";
    }

    @GetMapping(value = {"/receptionist/appointment-list"})
    public String showAppointmentListReceptionist(ModelMap modelMap) {
        String userTypeURL = "/receptionist/appointment-list";
        modelMap.put("userTypeURL", userTypeURL);
        List<AppointmentState> appointmentStates = Arrays.asList(AppointmentState.values());

        modelMap.putAll(appointmentListView(appointmentStates));
        return "user/appointment-list";
    }
    //***************************

    private ModelMap appointmentListView(List<AppointmentState> appointmentStates) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();
        List<Appointment> appointments = new ArrayList<>();

        Patient patient = patientService.findByUserId(userLogged.getUserId());
        for (AppointmentState appointmentState : appointmentStates) {
            appointments.addAll(appointmentService.findAllByPatientAndAppointmentStatus(patient, appointmentState.getStateNr()));
        }

        appointments.sort(null);

        ModelMap modelMap = new ModelMap();
        modelMap.put("specialities", specialities);
        modelMap.put("appointments", appointments);
        modelMap.put("user_logged", userLogged);
        return modelMap;
    }

}
