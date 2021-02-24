package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.UserService;

import java.io.IOException;


@Controller
public class RegistryController {
    // Attributes
    @Autowired
    UserService userService;

    @Autowired
    ImageUploadService imageUploadService;

    // Methods
    @GetMapping(value = "/registry")
    public String showRegistryPage(ModelMap modelMap) {
        modelMap.put("user", new User());

        return "registry";
    }

    @PostMapping(value = "/registryToLogin")
    public String returnToLoginPage(@ModelAttribute User user, @RequestParam("file") MultipartFile file) {
        userService.addUser(user);

        // TODO Adicionar lógica se utilizador não existir ou se for null
        try {
            // TODO dar nome de username
            imageUploadService.uploadImage(file, user.getUsername());
        } catch (IOException e) {
            // TODO return message error to page
            e.printStackTrace();
        }

        return "redirect:/login";
    }

    @GetMapping(value = "/temp")
    public String showRegistryPagetmp(ModelMap modelMap) {
        // TODO para testes
        modelMap.put("user", new User());

        return "registry-temp";
    }

    @PostMapping(value = "/temp")
    public String returnToLoginPagetmp(@RequestParam("file") MultipartFile file) {
        // TODO para testes
        try {
            // TODO dar nome de username
            imageUploadService.uploadImage(file, "user1");
        } catch (IOException e) {
            // TODO return message error to page
            e.printStackTrace();
        }

        return "redirect:/login";
    }

}
