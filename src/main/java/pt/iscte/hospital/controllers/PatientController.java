package pt.iscte.hospital.controllers;

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
import pt.iscte.hospital.objects.utils.Calendar;
import pt.iscte.hospital.objects.utils.Day;
import pt.iscte.hospital.objects.utils.Month;
import pt.iscte.hospital.services.DoctorService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PatientController {
    // Attributes
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    // Constructor

    // Methods
    @GetMapping(value = {"/patient/main", "/patient"})
    public String showPatientMain(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "patient/main";
    }

    @GetMapping(value = "/patient/appointment-list")
    public String showAppointmentList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        return "patient/appointment-list";
    }


    @GetMapping(value = "/patient/make-appointment")
    public String showMakeAppointment(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));

        User userLogged = userService.currentUser();

        LocalDate todayDate = LocalDate.now();
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
        modelMap.put("dayOfToday", dayOfToday);
        modelMap.put("year", year);
        modelMap.put("strMonth", strMonth);
        modelMap.put("user_logged", userLogged);
        return "patient/make-appointment";
    }


    @PostMapping(value = "/patient/make-appointment")
    public String makeAppointmentService(ModelMap modelMap,
                                         @RequestParam(required = false, name = "specialityName") String specialityName,
                                         @RequestParam(required = false, name = "doctorName") String doctorName,
                                         @RequestParam(required = false, name = "chosenDay") String chosenDay,
                                         @RequestParam(required = false, name = "arrowMonth") String arrowMonth) {

        LocalDate todayDate = LocalDate.now();
        int dayOfToday = todayDate.getDayOfMonth();
        int year = todayDate.getYear();
        String strMonth = Month.searchMonth(todayDate.getMonth().getValue());
        LocalDate date = LocalDate.parse(arrowMonth, FORMATTER);
        int calMonth = date.getMonth().getValue();

        // Se campos vazios
        if (doctorName == null || doctorName.isEmpty()) {
            doctorName = "";
        }
        if (specialityName == null || specialityName.isEmpty()) {
            specialityName = "";
        }
        if (chosenDay == null) {
            chosenDay = Integer.toString(dayOfToday);
        }

        if (arrowMonth != null) {
            // verificar se mes anterior ao actual -> erro
            // caso contrário somar +1mes ao proximo e -1 mes ao anterior !! cuidado com as passagens de ano

            calMonth = date.getMonth().getValue();
            strMonth = Month.searchMonth(calMonth);

            String previousMonth = date.minusMonths(1).format(FORMATTER);
            String nextMonth = date.plusMonths(1).format(FORMATTER);

        }

        // TODO lógica
        // envio de dados para a página
        // alterar a página para receber dados

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Speciality speciality = specialityService.findByName(specialityName);
        List<Doctor> doctors = doctorService.findAllBySpecialityOrderByNameAsc(speciality);
        List<Day> calendar = Calendar.calendarList(year, calMonth);
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("search_speciality", specialityName);
        modelMap.put("search_doctor", doctorName);
        modelMap.put("calendarDays", calendar);
        modelMap.put("dayOfToday", dayOfToday);
        modelMap.put("year", year);
        modelMap.put("strMonth", strMonth);
        modelMap.put("arrowMonth", arrowMonth);
        modelMap.put("chosenDay", chosenDay);
        modelMap.put("user_logged", userLogged);


        return ("patient/make-appointment");
    }


}
