package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping(value = "/user")
    public String showUserPage(){
        return "user";
    }
    @GetMapping(value="/userToMain")
    public String getMainPage(){
        return "redirect:/main";
    }

}
