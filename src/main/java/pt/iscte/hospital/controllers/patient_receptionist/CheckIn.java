package pt.iscte.hospital.controllers.patient_receptionist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    UserService userService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    SpecialityService specialityService;

    @GetMapping(value = "/patient/checkin")
    public String pageCheckIn(ModelMap modelMap) {
        User userLogged = userService.currentUser();
        Long userId = userLogged.getUserId();
        LocalDate date = LocalDate.now();

        List<Appointment> appointments = appointmentService.findAllByPatientUserIdBySlotDateAndAppointmentStatusAndHasChecked(
                userId,
                date,
                MARCADA.getStateNr(),
                false);


        modelMap.addAllAttributes(checkInView(
                appointments,
                userLogged,
                PATIENT_TYPE_URL,
                null,
                null,
                null,
                null));
        return USER_TYPE_URL;
    }

    private ModelMap checkInView(List<Appointment> appointments,
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
