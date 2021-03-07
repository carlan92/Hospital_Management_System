package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.security.IAuthenticationFacade;
import pt.iscte.hospital.services.DoctorService;
import pt.iscte.hospital.services.PatientService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.UserService;

import java.util.List;

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






}
