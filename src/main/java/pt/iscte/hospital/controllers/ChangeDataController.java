package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.NationalityService;
import pt.iscte.hospital.services.RegistrationService;
import pt.iscte.hospital.services.UserService;

import java.io.IOException;
import java.util.List;

@Controller
public class ChangeDataController {




}
