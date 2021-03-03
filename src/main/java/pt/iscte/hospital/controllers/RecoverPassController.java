package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.services.LoginService;
import pt.iscte.hospital.services.UserService;


@Controller
public class RecoverPassController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/recoverPass")
    public String showRecoverPassPage(ModelMap modelMap) {
        modelMap.put("username", "");
        modelMap.put("user_nif", "");

        return "recoverPass";
    }


    @PostMapping(value = "/recoverToLogin")
    public String returnToLoginPage(ModelMap modelMap, @RequestParam String username, @RequestParam Long user_nif,
                                    @RequestParam String password1, @RequestParam String password2) {
        if (loginService.validateUserNIF(username, user_nif)) {
            if (password1.equals(password2)) {
                Patient user = userService.findUser(username);
                user.setPassword(password1);
                userService.addUser(user);
                return "redirect:/login";
            } else {
                modelMap.put("errorMessage", "Palavras-passe não coincidem");
            }
        } else {
            modelMap.put("errorMessage", "Username/NIF inválido");
        }
        modelMap.put("username", username);
        modelMap.put("user_nif", user_nif);
        return "recoverPass";
    }

}