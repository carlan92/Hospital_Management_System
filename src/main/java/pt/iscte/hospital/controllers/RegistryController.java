package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.UserService;

@Controller
public class RegistryController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/registry")
    public String showRegistryPage(ModelMap modelMap){
        modelMap.put("user", new User());

        return "registry";
    }

    @PostMapping(value="/registryToLogin")
    public String returnToLoginPage(@ModelAttribute User user){
        userService.addUser(user);

        return "redirect:/login";
    }



}
