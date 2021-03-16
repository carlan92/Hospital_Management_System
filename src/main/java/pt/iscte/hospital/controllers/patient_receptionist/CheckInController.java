package pt.iscte.hospital.controllers.patient_receptionist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.controllers.utils.Common;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.AppointmentService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.user.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static pt.iscte.hospital.entities.states.AppointmentState.MARCADA;

@Controller
public class CheckInController {
    private static final String PATIENT_TYPE_URL = "/patient/checkin";
    private static final String RECEPTIONIST_TYPE_URL = "/receptionist/checkin";
    private static final String USER_TYPE_URL = "patient-receptionist/checkin";
    private static final String PATIENT_CHECK_IN_LINK = "/patient/checkin/%s";
    private static final String RECEPTIONIST_CHECK_IN_LINK = "/receptionist/checkin/%s";
    private static final String REDIRECT_URL = "redirect:%s";

    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private Common common;

    @GetMapping(value = "/patient/checkin")
    public String pageCheckInByPatient(ModelMap modelMap) {
        User userLogged = userService.currentUser();
        Long userId = userLogged.getUserId();
        LocalDate date = LocalDate.now();

        List<Appointment> appointments = appointmentService.findAllByPatientUserIdAndSlotDateAndAppointmentStatus(
                userId,
                date,
                MARCADA.getStateNr());
        appointments.sort(null);

        modelMap.addAllAttributes(checkInView(
                appointments,
                PATIENT_TYPE_URL,
                PATIENT_CHECK_IN_LINK,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    @GetMapping(value = "/patient/checkin/{appointmentId}")
    public String pageCheckInDonebyPatient(ModelMap modelMap,
                                           @PathVariable("appointmentId") Long appointmentId) {
        User userLogged = userService.currentUser();
        Long userId = userLogged.getUserId();

        // Fazer check in e salvar
        Appointment appointmentCheckIn = appointmentService.findByAppointmentId(appointmentId);
        if (appointmentCheckIn.getPatient().getUserId().equals(userId)) {
            appointmentCheckIn.setHasChecked(true);
            appointmentCheckIn.setTimeOfArrival(LocalTime.now());
            appointmentService.saveAppointment(appointmentCheckIn);
        }

        return String.format(REDIRECT_URL, PATIENT_TYPE_URL);
    }

    // Receptionist
    @GetMapping(value = "/receptionist/checkin")
    public String pageCheckInByReceptionist(ModelMap modelMap) {
        LocalDate date = LocalDate.now();

        List<Appointment> appointments = appointmentService.findAllBySlotDateAndAppointmentStatus(
                date,
                MARCADA.getStateNr());
        appointments.sort(null);

        modelMap.addAllAttributes(checkInView(
                appointments,
                RECEPTIONIST_TYPE_URL,
                RECEPTIONIST_CHECK_IN_LINK,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }


    @PostMapping(value = "/receptionist/checkin")
    public String pageCheckInByReceptionistSearch(ModelMap modelMap,
                                                  @RequestParam(required = false) String specialityName,
                                                  String doctorName,
                                                  String patientName) {
        User userLogged = userService.currentUser();
        LocalDate date = LocalDate.now();

        if(specialityName == null){
            specialityName = "";
        }

        List<Appointment> appointments = appointmentService.findAllBySlotDateAndAppointmentStatusAndSlotDoctorSpecialityNameContainingIgnoreCaseAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCase(
                date,
                MARCADA.getStateNr(),
                specialityName,
                doctorName,
                patientName);

        modelMap.addAllAttributes(checkInView(
                appointments,
                RECEPTIONIST_TYPE_URL,
                RECEPTIONIST_CHECK_IN_LINK,
                specialityName,
                doctorName,
                patientName));
        return USER_TYPE_URL;
    }

    @GetMapping(value = "/receptionist/checkin/{appointmentId}")
    public String pageCheckInDoneByReceptionist(ModelMap modelMap,
                                                @PathVariable("appointmentId") Long appointmentId) {
        // Fazer check in e salvar
        saveCheckIn(appointmentId);

        return String.format(REDIRECT_URL, RECEPTIONIST_TYPE_URL);
    }

    @PostMapping(value = "/receptionist/checkinbyAppointmentId")
    public String pageCheckInByAppointmentByReceptionist(ModelMap modelMap,
                                                         @RequestParam(required = false) Long appointmentId) {
        // Fazer check in e salvar
        if (appointmentId != null) {
            saveCheckIn(appointmentId);
        }

        return String.format(REDIRECT_URL, RECEPTIONIST_TYPE_URL);
    }

    private void saveCheckIn(Long appointmentId) {
        Appointment appointmentCheckIn = appointmentService.findByAppointmentId(appointmentId);
        appointmentCheckIn.setHasChecked(true);
        appointmentCheckIn.setDate(LocalDate.now());
        appointmentCheckIn.setTimeOfArrival(LocalTime.now());
        appointmentService.saveAppointment(appointmentCheckIn);
    }

    private ModelMap checkInView(List<Appointment> appointments,
                                 String userTypeURL,
                                 String checkInLink,
                                 String specialityName,
                                 String doctorName,
                                 String patientName) {
        ModelMap modelMap = new ModelMap();

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.addAllAttributes(common.sideNavMap());
        modelMap.put("specialities", specialities);
        modelMap.put("appointments", appointments);
        modelMap.put("checkInLink", checkInLink);
        modelMap.put("userTypeURL", userTypeURL);
        modelMap.put("specialityName", specialityName);
        modelMap.put("doctorName", doctorName);
        modelMap.put("patientName", patientName);
        return modelMap;
    }

}
