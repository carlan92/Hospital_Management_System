package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iscte.hospital.controllers.utils.Common;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.objects.utils.TimeInterval;
import pt.iscte.hospital.services.*;
import pt.iscte.hospital.services.user.DoctorService;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
public class TestController {

    private final Common common;
    private final SlotService slotService;
    private final DoctorService doctorService;

    @Autowired
    public TestController(Common common, SlotService slotService, DoctorService doctorService) {
        this.common = common;
        this.slotService = slotService;
        this.doctorService = doctorService;
    }


    @GetMapping(value = "/test/slot")
    public void generateSlots() {

        int duration = 60;
        List<TimeInterval> timeIntervalList = new ArrayList<>();
        List<DayOfWeek> weekDaysList = new ArrayList<>();
        int year = 2021;
        int month = 3;
        List<Doctor> doctors = doctorService.findAll();

        timeIntervalList.add(new TimeInterval(LocalTime.of(9, 0), LocalTime.of(12, 0)));
        timeIntervalList.add(new TimeInterval(LocalTime.of(13, 0), LocalTime.of(17, 0)));

        /*weekDaysList.add(DayOfWeek.MONDAY);
        weekDaysList.add(DayOfWeek.TUESDAY);
        weekDaysList.add(DayOfWeek.WEDNESDAY);*/
        /*weekDaysList.add(DayOfWeek.THURSDAY);
        weekDaysList.add(DayOfWeek.FRIDAY);*/
        weekDaysList.add(DayOfWeek.SATURDAY);
        weekDaysList.add(DayOfWeek.SUNDAY);

        slotService.generateSlots(duration, timeIntervalList, weekDaysList, year, month, doctors);
    }


}
