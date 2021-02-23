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
import pt.iscte.hospital.services.UserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class RegistryController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/registry")
    public String showRegistryPage(ModelMap modelMap){
        modelMap.put("user", new User());

        return "registry";
    }

    @PostMapping(value="/registryToLogin")
    public String returnToLoginPage(@ModelAttribute User user, @RequestParam("file") MultipartFile file){
        userService.addUser(user);

        return "redirect:/login";
    }

    @GetMapping(value = "/temp")
    public String showRegistryPagetmp(ModelMap modelMap){
        modelMap.put("user", new User());

        return "registry-temp";
    }

    @PostMapping(value="/temp")
    public String returnToLoginPagetmp(@RequestParam("file") MultipartFile file){
        /*System.out.println(file.toString());*/
        String dirSavePath = "uploaded_images/";
        /*System.out.println(Paths.get(dirSavePath).toAbsolutePath().normalize().toFile());*/

        try {
            file.transferTo(new File(Paths.get(dirSavePath).toAbsolutePath().normalize().toFile(), file.getOriginalFilename()) );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/login";
    }

}
