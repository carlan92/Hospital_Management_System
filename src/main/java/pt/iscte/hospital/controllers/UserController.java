package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/user")
    public String showUserPage(ModelMap modelMap){
        User userLogged = userService.currentUser();
        modelMap.put("user_logged", userLogged);
        return "user";
    }
    @GetMapping(value="/userToMain")
    public String getMainPage(){
        return "redirect:/main";
    }

}
