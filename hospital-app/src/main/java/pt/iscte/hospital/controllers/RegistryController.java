package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistryController {
    @GetMapping(value = {"/registry"})
    public String showLoginPage(){
        return "registry";
    }

}
