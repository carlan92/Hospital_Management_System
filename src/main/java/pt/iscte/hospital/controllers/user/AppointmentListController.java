package pt.iscte.hospital.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.repositories.AppointmentRepository;
import pt.iscte.hospital.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pt.iscte.hospital.entities.states.AppointmentState.*;

@Controller
public class AppointmentListController {
    private static final String PATIENT_CURRENT_TYPE_URL = "/patient/appointment-list/current";
    private static final String PATIENT_PAST_TYPE_URL = "/patient/appointment-list/past";
    private static final String DOCTOR_TYPE_URL = "/doctor/appointment-list";
    private static final String RECEPTIONIST_TYPE_URL = "/receptionist/appointment-list";
    private static final String USER_TYPE_URL = "user/appointment-list";

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

    @Autowired
    private AppointmentRepository appointmentRepository;


    // Constructor

    // Methods
    //*************************
    @GetMapping(value = {"/patient/appointment-list/current"})
    public String showAppointmentListPatientCurrent(ModelMap modelMap) {
        User userLogged = userService.currentUser();
        List<Appointment> appointments = new ArrayList<>();
        List<AppointmentState> appointmentStates = Arrays.asList(MARCADA);

        Patient patient = patientService.findByUserId(userLogged.getUserId());
        for (AppointmentState appointmentState : appointmentStates) {
            appointments.addAll(appointmentService.findAllByPatientAndAppointmentStatus(patient, appointmentState.getStateNr()));
        }
        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                PATIENT_CURRENT_TYPE_URL,
                null,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    @GetMapping(value = {"/patient/appointment-list/past"})
    public String showAppointmentListPatientPast(ModelMap modelMap) {
        User userLogged = userService.currentUser();
        List<Appointment> appointments = new ArrayList<>();
        List<AppointmentState> appointmentStates = Arrays.asList(DESMARCADA_PELO_UTENTE,
                DESMARCADA_PELO_MEDICO,
                REALIZADA,
                NAO_REALIZADA);

        Patient patient = patientService.findByUserId(userLogged.getUserId());
        for (AppointmentState appointmentState : appointmentStates) {
            appointments.addAll(appointmentService.findAllByPatientAndAppointmentStatus(patient, appointmentState.getStateNr()));
        }
        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                PATIENT_PAST_TYPE_URL,
                null,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    @GetMapping(value = {"/doctor/appointment-list"})
    public String showAppointmentListDoctor(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        Long userId = userLogged.getUserId();

        List<Appointment> appointments = new ArrayList<>(appointmentRepository.findAllBySlotDoctorUserId(userId));
        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                DOCTOR_TYPE_URL,
                null,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    @GetMapping(value = {"/receptionist/appointment-list"})
    public String showAppointmentListReceptionist(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        List<Appointment> appointments = new ArrayList<>(appointmentRepository.findAll());
        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                RECEPTIONIST_TYPE_URL,
                null,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    //***************************
    //*************************
    @PostMapping(value = {"/patient/appointment-list/current"})
    public String showAppointmentListPatientCurrentPost(ModelMap modelMap,
                                                        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                        @RequestParam(required = false) String specialityName,
                                                        @RequestParam String doctorName) {
        User userLogged = userService.currentUser();
        List<Appointment> appointments = new ArrayList<>();
        List<AppointmentState> appointmentStates = Arrays.asList(MARCADA);

        if (specialityName == null) {
            specialityName = "";
        }

        for (AppointmentState appointmentState : appointmentStates) {
            if (date == null) {
                appointments.addAll(appointmentRepository.findAllByPatientUserIdAndAppointmentStatusAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(userLogged.getUserId(),
                        appointmentState.getStateNr(),
                        doctorName,
                        specialityName));
            } else {
                appointments.addAll(appointmentRepository.findAllByPatientUserIdAndAppointmentStatusAndSlotDateAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(userLogged.getUserId(),
                        appointmentState.getStateNr(),
                        date,
                        doctorName,
                        specialityName));
            }
        }
        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                PATIENT_CURRENT_TYPE_URL,
                date,
                specialityName,
                doctorName,
                null));
        return USER_TYPE_URL;
    }

    @PostMapping(value = {"/patient/appointment-list/past"})
    public String showAppointmentListPatientPastPost(ModelMap modelMap,
                                                     @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                     @RequestParam(required = false) String specialityName,
                                                     @RequestParam String doctorName) {
        User userLogged = userService.currentUser();
        List<Appointment> appointments = new ArrayList<>();
        List<AppointmentState> appointmentStates = Arrays.asList(DESMARCADA_PELO_UTENTE,
                DESMARCADA_PELO_MEDICO,
                REALIZADA,
                NAO_REALIZADA);

        if (specialityName == null) {
            specialityName = "";
        }

        for (AppointmentState appointmentState : appointmentStates) {
            if (date == null) {
                appointments.addAll(appointmentRepository.findAllByPatientUserIdAndAppointmentStatusAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(userLogged.getUserId(),
                        appointmentState.getStateNr(),
                        doctorName,
                        specialityName));
            } else {
                appointments.addAll(appointmentRepository.findAllByPatientUserIdAndAppointmentStatusAndSlotDateAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(userLogged.getUserId(),
                        appointmentState.getStateNr(),
                        date,
                        doctorName,
                        specialityName));
            }
        }
        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                PATIENT_PAST_TYPE_URL,
                date,
                specialityName,
                doctorName,
                null));
        return USER_TYPE_URL;
    }

    @PostMapping(value = {"/doctor/appointment-list"})
    public String showAppointmentListDoctorPost(ModelMap modelMap,
                                                @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                @RequestParam(required = false) String specialityName,
                                                @RequestParam String patientName) {
        User userLogged = userService.currentUser();

        if (specialityName == null) {
            specialityName = "";
        }

        Long userId = userLogged.getUserId();

        List<Appointment> appointments;
        if (date == null) {
            appointments = appointmentRepository.findAllByPatientNameContainingIgnoreCaseAndSlotDoctorUserId(patientName,
                    userId);
        } else {
            appointments = appointmentRepository.findAllBySlotDateAndPatientNameContainingIgnoreCaseAndSlotDoctorUserId(date,
                    patientName,
                    userId);
        }

        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                DOCTOR_TYPE_URL,
                date,
                specialityName,
                null,
                patientName));
        return USER_TYPE_URL;
    }

    @PostMapping(value = {"/receptionist/appointment-list"})
    public String showAppointmentListReceptionistPost(ModelMap modelMap,
                                                      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                      @RequestParam(required = false) String specialityName,
                                                      @RequestParam String patientName,
                                                      @RequestParam String doctorName) {
        User userLogged = userService.currentUser();

        if (specialityName == null) {
            specialityName = "";
        }

        List<Appointment> appointments;
        if (date == null) {
            appointments = appointmentRepository.findAllBySlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(doctorName,
                    patientName,
                    specialityName);
        } else {
            appointments = appointmentRepository.findAllBySlotDateAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(date,
                    doctorName,
                    patientName,
                    specialityName);
        }

        appointments.sort(null);

        modelMap.addAllAttributes(appointmentListView(
                appointments,
                userLogged,
                RECEPTIONIST_TYPE_URL,
                date,
                specialityName,
                doctorName,
                patientName));
        return USER_TYPE_URL;
    }
    //***************************


    private ModelMap appointmentListView(List<Appointment> appointments,
                                         User userLogged,
                                         String userTypeURL,
                                         LocalDate date,
                                         String specialityName,
                                         String doctorName,
                                         String patientName) {
        ModelMap modelMap = new ModelMap();

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.put("specialities", specialities);
        modelMap.put("appointments", appointments);
        modelMap.put("user_logged", userLogged);
        modelMap.put("userTypeURL", userTypeURL);
        modelMap.put("date", date);
        modelMap.put("specialityName", specialityName);
        modelMap.put("doctorName", doctorName);
        modelMap.put("patientName", patientName);
        return modelMap;
    }

}
