package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.objects.utils.Calendar;
import pt.iscte.hospital.objects.utils.Day;
import pt.iscte.hospital.services.DoctorService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Day> calendar = Calendar.calendarList();
        User userLogged = userService.currentUser();
        int dayOfToday = LocalDate.now().getDayOfMonth();

        modelMap.put("specialities", specialities);
        modelMap.put("calendarDays", calendar);
        modelMap.put("dayOfToday", dayOfToday);
        modelMap.put("user_logged", userLogged);
        return "patient/make-appointment";
    }


    @PostMapping(value = "/patient/make-appointment")
    public String makeAppointmentService(ModelMap modelMap,
                                         @RequestParam(required = false, name = "specialityName") String specialityName,
                                         @RequestParam(required = false, name = "doctorName") String doctorName,
                                         @RequestParam(required = false, name = "chosenDay") String chosenDay) {
        int dayOfToday = LocalDate.now().getDayOfMonth();
        // Se campos vazios
        System.out.println("dia: " + chosenDay);
        if (doctorName == null || doctorName.isEmpty()) {
            doctorName = "";
        }
        if (specialityName == null || specialityName.isEmpty()) {
            specialityName = "";
        }
        if (chosenDay == null) {
            chosenDay = Integer.toString(dayOfToday);
        }

        // TODO lógica
        // envio de dados para a página
        // alterar a página para receber dados

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Speciality speciality = specialityService.findByName(specialityName);
        List<Doctor> doctors = doctorService.findAllBySpecialityOrderByNameAsc(speciality);
        List<Day> calendar = Calendar.calendarList();
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("search_speciality", specialityName);
        modelMap.put("search_doctor", doctorName);
        modelMap.put("calendarDays", calendar);
        modelMap.put("dayOfToday", dayOfToday);
        modelMap.put("chosenDay", chosenDay);
        modelMap.put("user_logged", userLogged);


        return ("patient/make-appointment");
    }


}
