package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.User;

@Controller
public class MainController {
    @GetMapping(value = "/main")
    public String showMainPage(ModelMap modelMap){
        User user = Login.getConnectedUser();
        modelMap.put("user", user);
        if(!Login.isConnected()){
            return "redirect:/";
        }
        return "main";
    }

    @GetMapping(value = "/doctor-inicio")
    public String showDoctorInicio(ModelMap modelMap){
        return "doctor-inicio";
    }

}
