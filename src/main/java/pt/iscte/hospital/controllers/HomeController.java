package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.Login;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String showHomePage(){
        if(Login.isConnected()){
            return "redirect:/main";
        }
        return "home";
    }
    @GetMapping(value="/homeToLogin")
    public String getLoginPage(){
        return "redirect:/login";
    }
}
