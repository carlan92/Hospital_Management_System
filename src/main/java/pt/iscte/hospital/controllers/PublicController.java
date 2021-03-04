package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.LoginService;
import pt.iscte.hospital.services.UserService;

@Controller
public class PublicController {
@Autowired
private UserService userService;
@Autowired
private LoginService loginService;

    @GetMapping(value = "/public/contacts")
    public String ShowContacts(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "public/contacts";
    }

    @GetMapping(value = "/public/main")
    public String showMainPage(){//TODO

        return "public/main";
    }

    @GetMapping(value = "/public/general-information")
    public String showGeneralInformation (ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "public/general-information";
    }

    @GetMapping(value = "/public/login")
    public String showLoginPage(){

        return "public/login";
    }

    @PostMapping(value = {"/public/login","/public/main"})
    public String validateLogin(ModelMap map, @RequestParam String username, @RequestParam String password) {
        if (loginService.validateLogin(username, password)) {
            //true
            //Login.setConnectedUser(userService.findByUsername(username)); TODO
            return "redirect:/public/main";
        } else {
            //Invalid Credentials
            map.put("errorMessage", "Username/Palavra-passe inválida");
            return "public/login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(){
        Login.logout();
        return "redirect:/public/main"; // redirects to home page
    }

    @GetMapping(value = "/public/recover-password")
    public String showRecoverPasswordPage(ModelMap modelMap) {
        modelMap.put("username", "");
        modelMap.put("user_nif", "");

        return "public/recover-password";
    }

}
