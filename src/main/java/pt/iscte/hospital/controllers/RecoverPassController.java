package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RecoverPassController {

    @GetMapping(value = "/recoverPass")
    public String showRecoverPassPage() {
        return "recoverPass";
    }


    @PostMapping(value = "/recoverToLogin")
    public String returnToLoginPage() {
        return "redirect:/login";
    }

}