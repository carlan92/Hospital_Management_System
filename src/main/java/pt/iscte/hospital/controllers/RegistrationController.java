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
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.UserService;

import java.io.IOException;


@Controller
public class RegistrationController {
    // Attributes
    @Autowired
    UserService userService;

    @Autowired
    ImageUploadService imageUploadService;

    // Methods
    @GetMapping(value = "/registration")
    public String showRegistrationPage(ModelMap modelMap) {
        modelMap.put("user", new User());

        return "registration";
    }

    @PostMapping(value = "/registrationToLogin")
    public String returnToLoginPage(@ModelAttribute User user, @RequestParam("file") MultipartFile file) {
        userService.addUser(user);

        // TODO Adicionar lógica se utilizador não existir ou se for null
        try {
            // TODO dar nome de username
            imageUploadService.uploadImage(file, user.getUsername());
        } catch (IOException e) {
            // TODO return message error to page
            e.printStackTrace();
        } catch (ImageTypeException e) {
            e.printStackTrace();
        } catch (ImageSizeException e) {
            e.printStackTrace();
        }

        return "redirect:/login";
    }

    @GetMapping(value = "/temp")
    public String showRegistrationPagetmp(ModelMap modelMap) {
        // TODO para testes
        modelMap.put("user", new User());

        return "registration-temp";
    }

    @PostMapping(value = "/temp")
    public String returnToLoginPagetmp(@RequestParam("file") MultipartFile file, ModelMap mpError) {
        try {
            // TODO dar nome de username
            imageUploadService.uploadImage(file, "user1");
        } catch (IOException e) {
            mpError.put("errorMsgPhotoUpload", "Erro ao fazer upload da imagem");
            return "registration-temp";
        } catch (ImageTypeException e) {
            mpError.put("errorMsgPhotoUpload", "Formato da imagem inválido. Usar jpg ou png.");
            return "registration-temp";
        } catch (ImageSizeException e) {
            mpError.put("errorMsgPhotoUpload", "Tamanho do ficheiro tem de ter no máximo " + imageUploadService.getImageMaxSize() + "MB");
            return "registration-temp";
        }

        return "redirect:/login";
    }

}
