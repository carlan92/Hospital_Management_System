package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.objects.utils.AlertMessageImage;
import pt.iscte.hospital.services.AppointmentService;
import pt.iscte.hospital.services.user.DoctorService;
import pt.iscte.hospital.services.user.PatientService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.user.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private AppointmentService appointmentService;
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

        // Informação do cabeçalho

        // Informação das consultas com check-in
        List<Appointment> todayCheckedInAppointments = todayCheckInAppointments();

        HashMap<Long, String> isFirstAppointmentCheckedIntMap = isFirstAppointmentMap(
                currentUser().getUserId(),
                todayCheckedInAppointments);


        // Informação das consultas a decorrer
        List<Appointment> todayOngoingAppointments = appointmentService.findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusOrderBySlotTimeBeginAsc(
                currentUser().getUserId(),
                dateToday,
                AppointmentState.EM_CURSO.getStateNr()
        );

        HashMap<Long, String> isFirstAppointmentOngoingMap = isFirstAppointmentMap(
                currentUser().getUserId(),
                todayOngoingAppointments);

        modelMap.addAllAttributes(infoForTopMain(currentUser().getUserId(), dateToday));

        modelMap.put("todayCheckedInAppointments", todayCheckedInAppointments);
        modelMap.put("isFirstAppointmentCheckedIntMap", isFirstAppointmentCheckedIntMap);
        modelMap.put("isFirstAppointmentOngoingMap", isFirstAppointmentOngoingMap);
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

    // Consulta
    @GetMapping(value = "/doctor/appointment/start/{appointmentId}")
    public String startAppointment(ModelMap modelMap,
                                   @PathVariable Long appointmentId) {
        modelMap.put("user_logged", currentUser());

        Appointment appointment = appointmentService.findByAppointmentId(appointmentId);

        Long appointmentDoctorId = appointment.getSlot().getDoctor().getUserId();

        // Verifica se o user tem acesso à consulta
        if (currentUser().getUserId().equals(appointmentDoctorId)) {
            doctorService.startAppointment(appointment);
        } else {
            modelMap.put("message", "Não foi possível iniciar a consulta. Pertence a outro médico");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
            return "components/alert-message";
        }

        return "redirect:/doctor/main";
    }

    @GetMapping(value = "/doctor/appointment/end/{appointmentId}")
    public String endAppointment(ModelMap modelMap,
                                 @PathVariable Long appointmentId) {
        modelMap.put("user_logged", currentUser());

        Appointment appointment = appointmentService.findByAppointmentId(appointmentId);

        Long appointmentDoctorId = appointment.getSlot().getDoctor().getUserId();

        // Verifica se o user tem acesso à consulta
        if (currentUser().getUserId().equals(appointmentDoctorId)) {
            doctorService.endAppointment(appointment);
            modelMap.put("message", "Consulta terminada.");
            modelMap.put("imageURL", AlertMessageImage.SUCCESS.getImageURL());
        } else {
            modelMap.put("message", "Não foi possível terminar a consulta. Pertence a outro médico");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
        }
        return "components/alert-message";
    }

    @GetMapping(value = "/doctor/appointment/cancel/{appointmentId}")
    public String cancelAppointment(ModelMap modelMap,
                                 @PathVariable Long appointmentId) {
        modelMap.put("user_logged", currentUser());

        Appointment appointment = appointmentService.findByAppointmentId(appointmentId);

        Long appointmentDoctorId = appointment.getSlot().getDoctor().getUserId();

        // Verifica se o user tem acesso à consulta
        if (currentUser().getUserId().equals(appointmentDoctorId)) {
            doctorService.desmarcarConsultaByDoctor(appointment);
            modelMap.put("message", "Consulta desmarcada.");
            modelMap.put("imageURL", AlertMessageImage.SUCCESS.getImageURL());
        } else {
            modelMap.put("message", "Não foi possível cancelar a consulta. Pertence a outro médico");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
        }
        return "components/alert-message";
    }

    @GetMapping(value = "/doctor/appointment/marcar-falta/{appointmentId}")
    public String marcarFaltaAppointment(ModelMap modelMap,
                                    @PathVariable Long appointmentId) {
        modelMap.put("user_logged", currentUser());

        Appointment appointment = appointmentService.findByAppointmentId(appointmentId);

        Long appointmentDoctorId = appointment.getSlot().getDoctor().getUserId();

        // Verifica se o user tem acesso à consulta
        if (currentUser().getUserId().equals(appointmentDoctorId)) {
            doctorService.marcarFalta(appointment);
            modelMap.put("message", "Falta marcada ao utente.");
            modelMap.put("imageURL", AlertMessageImage.SUCCESS.getImageURL());
        } else {
            modelMap.put("message", "Não foi possível marcar falta ao utente. Consulta pertence a outro médico");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
        }
        return "components/alert-message";
    }

    @GetMapping(value = "/doctor/appointment/remover-falta/{appointmentId}")
    public String desmarcarFaltaAppointment(ModelMap modelMap,
                                         @PathVariable Long appointmentId) {
        modelMap.put("user_logged", currentUser());

        Appointment appointment = appointmentService.findByAppointmentId(appointmentId);

        Long appointmentDoctorId = appointment.getSlot().getDoctor().getUserId();

        // Verifica se o user tem acesso à consulta
        if (currentUser().getUserId().equals(appointmentDoctorId)) {
            doctorService.removerFalta(appointment);
            modelMap.put("message", "Falta removida.");
            modelMap.put("imageURL", AlertMessageImage.SUCCESS.getImageURL());
        } else {
            modelMap.put("message", "Não foi possível remover falta ao utente. Consulta pertence a outro médico");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
        }
        return "components/alert-message";
    }




    // Private Methods
    private List<Appointment> todayCheckInAppointments(){
        LocalDate dateToday = LocalDate.now();
        List<Appointment> todayCheckedInAppointments = new ArrayList<>();

        List<Appointment> todayCheckedInAppointmentsMarcada = appointmentService.findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasCheckedOrderBySlotTimeBeginAsc(
                currentUser().getUserId(),
                dateToday,
                AppointmentState.MARCADA.getStateNr(),
                true
        );
        List<Appointment> todayCheckedInAppointmentsNaoRealizada = appointmentService.findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasCheckedOrderBySlotTimeBeginAsc(
                currentUser().getUserId(),
                dateToday,
                AppointmentState.NAO_REALIZADA.getStateNr(),
                true
        );
        todayCheckedInAppointments.addAll(todayCheckedInAppointmentsMarcada);
        todayCheckedInAppointments.addAll(todayCheckedInAppointmentsNaoRealizada);

        return todayCheckedInAppointments;
    }


    private HashMap<Long, String> isFirstAppointmentMap(Long doctorId, List<Appointment> appointments) {
        HashMap<Long, String> isFirstAppointmentMap = new HashMap<>();

        for (Appointment appointment : appointments) {
            long patientId = appointment.getPatient().getUserId();
            long count = appointmentService.countBySlotDoctorUserIdAndPatientUserIdAndAppointmentStatus(
                    doctorId,
                    patientId,
                    AppointmentState.REALIZADA.getStateNr());
            if (count > 0) {
                isFirstAppointmentMap.put(patientId, "Não");
            } else {
                isFirstAppointmentMap.put(patientId, "Sim");
            }
        }

        return isFirstAppointmentMap;
    }

    private ModelMap infoForTopMain(long doctorId, LocalDate dateToday) {
        ModelMap modelMap = new ModelMap();
        long pacientes_agendados = appointmentService.countBySlotDoctorUserIdAndSlotDateAndAppointmentStatus(
                doctorId,
                dateToday,
                AppointmentState.MARCADA.getStateNr()
        );

        long pacientes_confirmadosMarcado = appointmentService.countBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasChecked(
                doctorId,
                dateToday,
                AppointmentState.MARCADA.getStateNr(),
                true
        );

        long pacientes_confirmadosEmCurso = appointmentService.countBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasChecked(
                doctorId,
                dateToday,
                AppointmentState.EM_CURSO.getStateNr(),
                true
        );

        long pacientes_atendidos = appointmentService.countBySlotDoctorUserIdAndSlotDateAndAppointmentStatus(
                doctorId,
                dateToday,
                AppointmentState.REALIZADA.getStateNr()
        );

        long pacientes_confirmados = pacientes_confirmadosMarcado + pacientes_confirmadosEmCurso;

        long pacientes_faltaram = appointmentService.countBySlotDoctorUserIdAndSlotDateAndAppointmentStatus(
                doctorId,
                dateToday,
                AppointmentState.NAO_REALIZADA.getStateNr());

        modelMap.put("pacientes_agendados", pacientes_agendados);
        modelMap.put("pacientes_confirmados", pacientes_confirmados);
        modelMap.put("pacientes_atendidos", pacientes_atendidos);
        modelMap.put("pacientes_faltaram", pacientes_faltaram);
        return modelMap;
    }


    private User currentUser() {
        return userService.currentUser();
    }
}
