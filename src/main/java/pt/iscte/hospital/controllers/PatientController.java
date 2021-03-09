package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.objects.utils.Calendar;
import pt.iscte.hospital.objects.utils.Day;
import pt.iscte.hospital.objects.utils.Month;
import pt.iscte.hospital.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pt.iscte.hospital.entities.states.AppointmentState.*;
import static pt.iscte.hospital.objects.utils.Calendar.FORMATTER;

@Controller
public class PatientController {
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
    @GetMapping(value = {"/patient/main", "/patient"})
    public String showPatientMain(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "patient/main";
    }

    @GetMapping(value = {"/patient/appointment-list/present", "/patient/appointment-list"})
    public String showAppointmentListPresent(ModelMap modelMap) {
        List<AppointmentState> appointmentStates = Arrays.asList(MARCADA);

        modelMap.addAllAttributes(appointmentListView(appointmentStates));
        return "patient/appointment-list";
    }

    @GetMapping(value = "/patient/appointment-list/past")
    public String showAppointmentListPast(ModelMap modelMap) {
        List<AppointmentState> appointmentStates = Arrays.asList(
                DESMARCADA_PELO_UTENTE,
                DESMARCADA_PELO_MEDICO,
                REALIZADA,
                NAO_REALIZADA);

        modelMap.addAllAttributes(appointmentListView(appointmentStates));
        return "patient/appointment-list";
    }

    private ModelMap appointmentListView(List<AppointmentState> appointmentStates) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();
        Patient patient = patientService.findByUserId(userLogged.getUserId());
        List<Appointment> appointments = new ArrayList<>();

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


    @GetMapping(value = "/patient/make-appointment")
    public String showMakeAppointment(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        User userLogged = userService.currentUser();

        LocalDate todayDate = LocalDate.now();
        String chosenDay = todayDate.format(FORMATTER);
        int dayOfToday = todayDate.getDayOfMonth();
        int year = todayDate.getYear();
        int monthOfTodayNr = todayDate.getMonth().getValue();
        List<Day> calendar = Calendar.calendarList(year, monthOfTodayNr);

        String strMonth = Month.searchMonth(monthOfTodayNr);
        String nextMonth = todayDate.plusMonths(1).format(FORMATTER);
        String previousMonth = todayDate.minusMonths(1).format(FORMATTER);

        modelMap.put("specialities", specialities);
        modelMap.put("calendarDays", calendar);
        modelMap.put("nextMonth", nextMonth);
        modelMap.put("previousMonth", previousMonth);
        modelMap.put("previousArrowState", 0);
        modelMap.put("nextArrowState", 1);
        modelMap.put("dayOfToday", dayOfToday);
        modelMap.put("year", year);
        modelMap.put("strMonth", strMonth);
        modelMap.put("chosenDay", chosenDay);
        modelMap.put("user_logged", userLogged);
        return "patient/make-appointment";
    }


    @PostMapping(value = "/patient/make-appointment")
    public String makeAppointmentService(ModelMap modelMap,
                                         @RequestParam(required = false, name = "specialityName") String specialityName,
                                         @RequestParam(required = false, name = "doctorId") String doctorId,
                                         @RequestParam(required = false, name = "slotId") String slotId,
                                         @RequestParam(required = false, name = "chosenDay") String chosenDay,
                                         @RequestParam(required = false, name = "arrowMonth") String arrowMonth) {
        // **********
        LocalDate todayDate = LocalDate.now();
        LocalDate chosenDate;
        int dayOfToday;
        int calYear;
        int calMonth;
        String strMonth;
        String nextMonthDate;
        String previousMonthDate;
        int previousArrowState;
        int nextArrowState;

        // Foi selecionado um mês
        if (arrowMonth != null) {
            chosenDate = LocalDate.parse(arrowMonth, FORMATTER);
            if (chosenDate.getMonthValue() != todayDate.getMonthValue()) {
                chosenDay = chosenDate.withDayOfMonth(1).format(FORMATTER);
            } else {
                chosenDay = todayDate.format(FORMATTER);
            }
            // Foi selecionado um dia
        } else if (chosenDay != null && arrowMonth == null) {
            chosenDate = LocalDate.parse(chosenDay, FORMATTER);

            // Não existe dia selecionado
        } else {
            chosenDate = todayDate;
            chosenDay = todayDate.format(FORMATTER);
        }

        calYear = chosenDate.getYear();
        calMonth = chosenDate.getMonthValue();
        strMonth = Month.searchMonth(chosenDate.getMonthValue());
        nextMonthDate = chosenDate.plusMonths(1).format(FORMATTER);
        previousMonthDate = chosenDate.minusMonths(1).format(FORMATTER);

        // Lógica das setas + Condição para limitar a selecção de dias de calendário, dias anteriores ao dia actual
        if (chosenDate.getMonthValue() == todayDate.getMonthValue()) {
            previousArrowState = 0;
            nextArrowState = 1;
            dayOfToday = todayDate.getDayOfMonth();
        } else {
            previousArrowState = 1;
            nextArrowState = 0;     // colocar a 1 se não existir limitação para mostrar meses
            dayOfToday = 0;
        }

        // **********

        // Se campos vazios
        Doctor doctor = null;
        if (doctorId == null || doctorId.isEmpty()) {
            doctorId = "";
        } else {
            doctor = doctorService.findByUserId(Long.parseLong(doctorId));
        }

        if (specialityName == null || specialityName.isEmpty()) {
            specialityName = "";
        }

        // envio de dados para a página
        // alterar a página para receber dados

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Speciality speciality = specialityService.findByName(specialityName);
        List<Doctor> doctors = doctorService.findAllBySpecialityOrderByNameAsc(speciality);
        List<Slot> slots = slotService.findAllByDoctorAndIsAvailableAndDateOrderByTimeBeginAsc(doctor, true, chosenDate);
        List<Day> calendar = Calendar.calendarList(calYear, calMonth);
        if (!doctorId.isEmpty()) {
            calendar = slotService.calendarColor(calendar, doctor);
        }
        User userLogged = userService.currentUser();

        // Marcar consulta
        if (slotId != null && !slotId.isEmpty()) {
            // Encontrar slot por id
            Slot slot = slotService.findBySlotId(Long.parseLong(slotId));

            // Marcar slot como marcada/indisponível
            slot.setAvailable(false);

            // Actualizar slot na base de dados
            slotService.saveSlot(slot);

            // Adicionar consulta à base de dados
            Appointment appointment = new Appointment();
            Patient patient = patientService.findByUsername(userService.currentUser().getUsername());
            appointment.setPatient(patient);
            appointment.setSlot(slot);
            appointment.setAppointmentStatus(MARCADA.getStateNr());

            appointmentService.saveAppointment(appointment);
            System.out.println("Sucesso: consulta marcada - " + appointment + slot);

            // TODO Redireccionar à página de sucesso de marcação
            return "redirect:/patient/main";
        }

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("slots", slots);
        modelMap.put("search_speciality", specialityName);
        modelMap.put("search_doctor", doctorId);
        modelMap.put("search_slot", slotId);
        modelMap.put("calendarDays", calendar);
        modelMap.put("nextMonth", nextMonthDate);
        modelMap.put("previousMonth", previousMonthDate);
        modelMap.put("previousArrowState", previousArrowState);
        modelMap.put("nextArrowState", nextArrowState);
        modelMap.put("dayOfToday", dayOfToday);
        modelMap.put("year", calYear);
        modelMap.put("strMonth", strMonth);
        modelMap.put("chosenDay", chosenDay);
        modelMap.put("user_logged", userLogged);
        return ("patient/make-appointment");
    }
}
