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

    private static final String errorMsgName = "";
    private static final String errorMsgSex = "";
    private static final String errorMsgBirthday = "";
    private static final String errorMsgAddress = "";
    private static final String errorMsgPostalCode = "";
    private static final String errorMsgCity = "";
    private static final String errorMsg7 = "";
    private static final String errorMsg8 = "";
    private static final String errorMsg9 = "";
    private static final String errorMsg10 = "";
    private static final String errorMsg11 = "";
    private static final String errorMsg12 = "";
    private static final String errorMsg13 = "";
    private static final String errorMsgPhone = "";
    private static final String errorMsgEmail = "";
    private static final String errorMsgUsername = "";
    private static final String errorMsgUsername2 = "";
    private static final String errorMsg18 = "";


    private static final String errorMsgPhotoUpload = "Erro ao fazer upload da imagem";
    private static final String errorMsgImageType = "Formato da imagem inválido. Usar jpg ou png.";
    private static final String errorMsgImageSize = "Tamanho máximo permitido para a foto é de ";


    // Methods
    @GetMapping(value = "/registration")
    public String showRegistrationPage(ModelMap modelMap) {
        modelMap.put("user", new User());

        return "registration";
    }

    @PostMapping(value = "/registrationToLogin")
    public String returnToLoginPage(@ModelAttribute User user,
                                    @RequestParam("file") MultipartFile file,
                                    ModelMap mpError) {

        // TODO verificar elementos do user
        userService.addUser(user);

        if (file != null || !file.isEmpty()) {
            try {
                imageUploadService.uploadImage(file, user.getUsername());
            } catch (IOException e) {
                mpError.put("errorMsgPhotoUpload", errorMsgPhotoUpload);
                return "registration-temp";
            } catch (ImageTypeException e) {
                mpError.put("errorMsgPhotoUpload", errorMsgImageType);
                return "registration-temp";
            } catch (ImageSizeException e) {
                mpError.put("errorMsgPhotoUpload", errorMsgImageSize+ imageUploadService.getImageMaxSize() + "MB");
                return "registration-temp";
            }
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
    public String returnToLoginPagetmp(@RequestParam("file") MultipartFile file,
                                       ModelMap mpError) {

        try {
            // TODO dar nome de username
            imageUploadService.uploadImage(file, "user1");
        } catch (IOException e) {
            mpError.put("errorMsgPhotoUpload", errorMsgPhotoUpload);
            return "registration-temp";
        } catch (ImageTypeException e) {
            mpError.put("errorMsgPhotoUpload", errorMsgImageType);
            return "registration-temp";
        } catch (ImageSizeException e) {
            mpError.put("errorMsgPhotoUpload", errorMsgImageSize + imageUploadService.getImageMaxSize() + "MB");
            return "registration-temp";
        }

        return "redirect:/login";
    }

}
