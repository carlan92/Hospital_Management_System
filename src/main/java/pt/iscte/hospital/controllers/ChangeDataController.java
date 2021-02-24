package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Login;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChangeDataController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/change_data")
    public String goToChangeData(ModelMap modelMap) {
        modelMap.put("user", Login.getConnectedUser());
        return "change_data";
    }

    @PostMapping(value = "/change_data")
    public String returnToUserPage(ModelMap modelMap,
                                    @RequestParam String name,
                                    @RequestParam String sex,
                                    @DateTimeFormat (iso = DateTimeFormat.ISO.DATE)
                                    @RequestParam Date birthday,
                                    @RequestParam @Nullable String address,
                                    @RequestParam @Nullable String postCode,
                                    @RequestParam String city,
                                    @RequestParam String nationality,
                                    @RequestParam Long phone,
                                    @RequestParam String documentType,
                                    @RequestParam Long documentNumber,
                                    @RequestParam Long nif,
                                    @RequestParam @Nullable Long patientNumber) {


        //Date date = new Date(user.getBirthday().getTime());

        if (isDataValid()) {
            // Update user info
            User user = Login.getConnectedUser();
            user.setName(name);
            user.setSex(sex);
            user.setBirthday(birthday);
            user.setAddress(address);
            user.setPostCode(postCode);
            user.setCity(city);
            user.setNationality(nationality);
            user.setPhone(phone);
            user.setDocumentType(documentType);
            user.setDocumentNumber(documentNumber);
            user.setNif(nif);
            user.setPatientNumber(patientNumber);

            userService.addUser(user);

            return "redirect:/user";

        } else {
            // case error in info validation
            modelMap.put("errorMessage", "Dados inválidos");

            modelMap.put("name", name);
            modelMap.put("sex", sex);
            modelMap.put("birthday", birthday);
            modelMap.put("address", address);
            modelMap.put("postalCode", postCode);
            modelMap.put("city", city);
            modelMap.put("nationality", nationality);
            modelMap.put("phone", phone);
            modelMap.put("documentType", documentType);
            modelMap.put("documentNumber", documentNumber);
            modelMap.put("nif", nif);
            modelMap.put("patientNumber", patientNumber);

            return "change_data";
        }

    }

    private static boolean isDataValid(){
        // TODO add logic
        return true;
    }

}
