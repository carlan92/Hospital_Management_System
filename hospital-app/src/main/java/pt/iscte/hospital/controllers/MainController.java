package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.LogIn;
import pt.iscte.hospital.entities.User;

@Controller
public class MainController {
    @GetMapping(value = "/main")
    public String showMainPage(ModelMap modelMap){
        User user = LogIn.getConnectedUser();
        modelMap.put("user", user);
        return "main";
    }

}
