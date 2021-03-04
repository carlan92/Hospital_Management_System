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

    @GetMapping(value = {"/public/main", "/"})
    public String showMainPage() {
        User user = userService.currentUser();
        String mainPage = userService.getUserMainPage(user);
        return "redirect:" + mainPage;
    }

    @GetMapping(value = "/public/general-information")
    public String showGeneralInformation(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "public/general-information";
    }

    @GetMapping(value = "/public/login")
    public String showLoginPage() {

        return "public/login";
    }

    @PostMapping(value = {"/public/login", "/public/main"})
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

    @GetMapping(value = "/public/recover-password")
    public String showRecoverPasswordPage(ModelMap modelMap) {
        modelMap.put("username", "");
        modelMap.put("user_nif", "");

        return "public/recover-password";
    }

    @PostMapping(value = "/public/recover-password")
    public String recoverPassword(ModelMap modelMap,
                                  @RequestParam String username,
                                  @RequestParam Long user_nif,
                                  @RequestParam String password1,
                                  @RequestParam String password2) {
        if (loginService.validateUserNIF(username, user_nif)) {
            if (password1.equals(password2)) {
                User user = userService.findUser(username);
                user.setPassword(password1);
                userService.addUser(user);
                return "redirect:/public/login";
            } else {
                modelMap.put("errorMessage", "Palavras-passe não coincidem");
            }
        } else {
            modelMap.put("errorMessage", "Username/NIF inválido");
        }
        modelMap.put("username", username);
        modelMap.put("user_nif", user_nif);
        return "public/recover-password";
    }

}
