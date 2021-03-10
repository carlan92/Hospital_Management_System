package pt.iscte.hospital.controllers.patient_receptionist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.AppointmentService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.time.LocalDate;
import java.util.List;

import static pt.iscte.hospital.entities.states.AppointmentState.MARCADA;

@Controller
public class CheckIn {
    private static final String PATIENT_TYPE_URL = "/patient/checkin";
    private static final String RECEPTIONIST_TYPE_URL = "/receptionist/checkin";
    private static final String USER_TYPE_URL = "patient-receptionist/checkin";
    private static final String PATIENT_CHECK_IN_LINK = "/patient/checkin/%s";
    private static final String RECEPTIONIST_CHECK_IN_LINK = "/receptionist/checkin/%s";
    private static final String REDIRECT_URL = "redirect:/%s";

    @Autowired
    UserService userService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    SpecialityService specialityService;

    @GetMapping(value = "/patient/checkin")
    public String pageCheckInByPatient(ModelMap modelMap) {
        User userLogged = userService.currentUser();
        Long userId = userLogged.getUserId();
        LocalDate date = LocalDate.now();

        List<Appointment> appointments = appointmentService.findAllByPatientUserIdAndSlotDateAndAppointmentStatus(
                userId,
                date,
                MARCADA.getStateNr());

        modelMap.addAllAttributes(checkInView(
                appointments,
                userLogged,
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
        LocalDate date = LocalDate.now();

        // Fazer check in e salvar
        Appointment appointmentCheckIn = appointmentService.findByAppointmentId(appointmentId);
        if (appointmentCheckIn.getPatient().getUserId() == userId) {
            appointmentCheckIn.setHasChecked(true);
            appointmentService.saveAppointment(appointmentCheckIn);
        }

        List<Appointment> appointments = appointmentService.findAllByPatientUserIdAndSlotDateAndAppointmentStatus(
                userId,
                date,
                MARCADA.getStateNr());


        modelMap.addAllAttributes(checkInView(
                appointments,
                userLogged,
                PATIENT_TYPE_URL,
                PATIENT_CHECK_IN_LINK,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    @GetMapping(value = "/receptionist/checkin")
    public String pageCheckInByReceptionist(ModelMap modelMap) {
        User userLogged = userService.currentUser();
        Long userId = userLogged.getUserId();
        LocalDate date = LocalDate.now();

        List<Appointment> appointments = appointmentService.findAllBySlotDateAndAppointmentStatus(
                date,
                MARCADA.getStateNr());

        modelMap.addAllAttributes(checkInView(
                appointments,
                userLogged,
                RECEPTIONIST_TYPE_URL,
                RECEPTIONIST_CHECK_IN_LINK,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    @GetMapping(value = "/receptionist/checkin/{appointmentId}")
    public String pageCheckInDoneByReceptionist(ModelMap modelMap,
                                                @PathVariable("appointmentId") Long appointmentId) {
        User userLogged = userService.currentUser();
        Long userId = userLogged.getUserId();
        LocalDate date = LocalDate.now();

        // Fazer check in e salvar
        Appointment appointmentCheckIn = appointmentService.findByAppointmentId(appointmentId);
        appointmentCheckIn.setHasChecked(true);
        appointmentService.saveAppointment(appointmentCheckIn);

        List<Appointment> appointments = appointmentService.findAllBySlotDateAndAppointmentStatus(
                date,
                MARCADA.getStateNr());


        modelMap.addAllAttributes(checkInView(
                appointments,
                userLogged,
                RECEPTIONIST_TYPE_URL,
                RECEPTIONIST_CHECK_IN_LINK,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }


    private ModelMap checkInView(List<Appointment> appointments,
                                 User userLogged,
                                 String userTypeURL,
                                 String checkInLink,
                                 String specialityName,
                                 String doctorName,
                                 String patientName) {
        ModelMap modelMap = new ModelMap();

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        modelMap.put("specialities", specialities);
        modelMap.put("appointments", appointments);
        modelMap.put("user_logged", userLogged);
        modelMap.put("checkInLink", checkInLink);
        modelMap.put("userTypeURL", userTypeURL);
        modelMap.put("specialityName", specialityName);
        modelMap.put("doctorName", doctorName);
        modelMap.put("patientName", patientName);
        return modelMap;
    }

}
