package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.services.LoginService;
import pt.iscte.hospital.services.PatientService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/login")
    public String showLoginPage(){
        if(Login.isConnected()){
            return "main";
        }
        return "login";
    }

    @PostMapping(value = {"/login","/main"})
    public String validateLogin(ModelMap map, @RequestParam String username, @RequestParam String password) {
        if (loginService.validateLogin(username, password)) {
            //true
            Login.setConnectedUser(patientService.findByUsername(username));
            return "redirect:/main";
        } else {
            //Invalid Credentials
            map.put("errorMessage", "Username/Palavra-passe inválida");
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(){
        Login.logout();
        return "redirect:/"; // redirects to home page
    }

}
