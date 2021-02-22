package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.UserService;



@Controller
public class RecoverPassController  {

    @GetMapping(value = "/recoverPass")
    public String showRecoverPassPage(){
     return "recoverPass";
    }


}