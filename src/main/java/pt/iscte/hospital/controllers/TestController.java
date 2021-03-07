package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.objects.utils.TimeInterval;
import pt.iscte.hospital.security.IAuthenticationFacade;
import pt.iscte.hospital.services.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
public class TestController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private UserService userService;

    @Autowired
    private SlotService slotService;


    @GetMapping(value = "/test")
    public String pageTest(ModelMap modelMap) {


        System.out.println("User : " + authenticationFacade.getAuthentication().getName());
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "test";
    }

    @GetMapping(value = "/patient-receptionist/payments-history")
    public String page(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "patient-receptionist/payments-history";
    }

    @GetMapping(value = "/test/slot")
    public void generateSlots() {

        int duration = 20;
        List<TimeInterval> timeIntervalList = new ArrayList<>();
        List<DayOfWeek> weekDaysList = new ArrayList<>();
        int year = 2021;
        int month = 03;

        timeIntervalList.add(new TimeInterval(LocalTime.of(9,00),LocalTime.of(12,00) ));
        timeIntervalList.add(new TimeInterval(LocalTime.of(13,00),LocalTime.of(17,00) ));

        weekDaysList.add(DayOfWeek.MONDAY);
        weekDaysList.add(DayOfWeek.TUESDAY);
        weekDaysList.add(DayOfWeek.WEDNESDAY);

        slotService.generateSlots(duration, timeIntervalList, weekDaysList, year, month);
    }


}
