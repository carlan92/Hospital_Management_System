package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.UserService;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/main")
    public String showMainPage(ModelMap modelMap){
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);

        return "main";
    }

    @GetMapping(value = "/doctor-inicio")
    public String showDoctorInicio(ModelMap modelMap){
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "doctor-inicio";
    }

}
