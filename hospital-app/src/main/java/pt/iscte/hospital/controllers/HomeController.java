package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String showHomePage(){
        return "home";
    }
    @GetMapping(value="/homeToLogin")
    public String showLoginPage(){
        return "redirect:/login";
    }
}
