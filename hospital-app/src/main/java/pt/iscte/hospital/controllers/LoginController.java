package pt.iscte.hospital.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {


    @GetMapping(value = {"/", "/login"})
    public String showLoginPage(){
        return "login";
    }

}
