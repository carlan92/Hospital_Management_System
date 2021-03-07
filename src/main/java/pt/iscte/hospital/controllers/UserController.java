package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.services.*;

import pt.iscte.hospital.services.validation.UserValidationService;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private NationalityService nationalityService;
    @Autowired
    private UserValidationService userValidationService;

    @GetMapping(value = "/user/change-profile-data")
    public String showChangeProfileData(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityService.findAll();

        modelMap.put("nationalities", nationalities);
        modelMap.put("user_logged", userService.currentUser());
        modelMap.put("user", userService.currentUser());

        return "user/change-profile-data";
    }

    @PostMapping(value = "/user/change-profile-data")
    public String returnToUserPage(@ModelAttribute Patient user,
                                   ModelMap modelMap,
                                   @RequestParam("file") MultipartFile file) {

        // Update user info
        User connectedUser = userService.currentUser();

        userValidationService.setUser(user)
                .validName()
                .validPhone()
                .validPostCode()
                .validSex()
                .validDocumentType()
                .validDocumentNumber()
                .validPatientNumber()
                .validNif()
                .validCity()
                .validBirthday()
                .validNationality()
                .validAddress();

        if (!user.getDocumentNumber().equals(connectedUser.getDocumentNumber())) {
            userValidationService.validDocumentNumberUnique();
        }

        if (user.getPatientNumber() != connectedUser.getPatientNumber() && user.getPatientNumber() != null) {
           userValidationService.validPatientNumberUnique();
        }

        if (!user.getNif().equals(connectedUser.getNif())) {
            userValidationService.validNifUnique();
        }

        if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
            try {
                String photoURL = imageUploadService.uploadImage(file, userService.currentUser().getUsername());
                user.setPhotoURL(photoURL);
            } catch (IOException e) {
                userValidationService.notValidPhotoUpload();
            } catch (ImageTypeException e) {
                userValidationService.notValidImageType();
            } catch (ImageSizeException e) {
                userValidationService.notValidImageSize();
            }
        } else {
            user.setPhotoURL(userService.currentUser().getPhotoURL());
        }

        if (!userValidationService.isValid()) {
            // case error in info validation
            List<Nationality> nationalities = nationalityService.findAll();
            modelMap.addAllAttributes(userValidationService.getErrorModelMap());
            modelMap.put("nationalities", nationalities);

            modelMap.put("user_logged", userService.currentUser());
            modelMap.put("user", user);
            return "user/change-profile-data";
        }
        user.setUserId(userService.currentUser().getUserId());
        user.setEmail(userService.currentUser().getEmail());
        user.setUsername(userService.currentUser().getUsername());
        user.setPassword(userService.currentUser().getPassword());
        user.setAccount(userService.currentUser().getAccount());

        userService.addUser(user);

        return "redirect:/user/user-profile";
    }

    //change data form
    @GetMapping(value = "/user/user-profile")
    public String showUserProfile(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "user/user-profile";
    }

    @GetMapping(value = "/userToMain")
    public String showMainPage() {
        return "redirect:/";
    }


    @GetMapping(value = "/user/doctor-list")
    public String showDoctorList(ModelMap modelMap) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<Doctor> doctors = doctorService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "user/doctor-list";
    }

    @PostMapping(value = "/search-doctors")
    public String searchDoctors(@RequestParam(name = "name") String name,
                                @RequestParam(required = false, name = "speciality") String speciality,
                                ModelMap modelMap) {
        List<Doctor> doctors;
        if (speciality == null || speciality.isEmpty()) {
            speciality = "";
            doctors = doctorService.findAllByFirstAndLastName(name);
        } else {
            doctors = doctorService.findAllByFirstAndLastNameAndSpeciality(name, speciality);
        }

        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        User userLogged = userService.currentUser();

        modelMap.put("search_name", name);
        modelMap.put("search_speciality", speciality);
        modelMap.put("specialities", specialities);
        modelMap.put("doctors", doctors);
        modelMap.put("user_logged", userLogged);
        return "user/doctor-list";
    }

}
