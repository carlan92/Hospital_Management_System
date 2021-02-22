package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.LogIn;
import pt.iscte.hospital.services.LoginService;
import pt.iscte.hospital.repositories.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/login")
    public String showLoginPage(){
        return "/login";
    }

    @PostMapping(value = {"/login","/main"})
    public String validateLogin(ModelMap map, @RequestParam String user_email, @RequestParam String password) {
        if (loginService.validateLogin(user_email, password)) {
            //true
            LogIn.setConnectedUser(userRepository.findByEmail(user_email));
            return "redirect:/main";
        } else {
            //Invalid Credentials
            map.put("errorMessage", "Invalid Credentials");
            return "login";
        }
    }

}
