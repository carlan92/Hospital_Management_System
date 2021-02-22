package pt.iscte.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.User;

@Controller
public class UserController {
    @GetMapping(value = "/user")
    public String showUserPage(ModelMap modelMap){
        User user = Login.getConnectedUser();
        modelMap.put("user", user);
        return "user";
    }
    @GetMapping(value="/userToMain")
    public String getMainPage(){
        return "redirect:/main";
    }

}
