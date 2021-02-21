package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistryController {
    @GetMapping(value = "/registry")
    public String showRegistryPage(){
        return "registry";
    }

    @PostMapping(value="/registryToLogin")
    public String returnToLoginPage(){
        return "redirect:/login";
    }

}
