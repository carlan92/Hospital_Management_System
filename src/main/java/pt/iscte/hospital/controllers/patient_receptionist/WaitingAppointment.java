package pt.iscte.hospital.controllers.patient_receptionist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.user.DoctorService;
import pt.iscte.hospital.services.user.UserService;

import java.util.List;

@Controller
public class WaitingAppointment {
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

    //marcar pedido de lista de espera
    @PostMapping(value = "patient-receptionist/waitingAppointment")
    public String showMakeApplyForWaitingAppointment(ModelMap modelMap,
                                                     @RequestParam(required = false, name = "specialityName") String specialityName,
                                                     @RequestParam(required = false, name = "doctorId") String doctorId) {
        List<Speciality> specialities = specialityService.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Speciality speciality = specialityService.findByName(specialityName);

        User userLogged = userService.currentUser();

        Doctor doctor = null;
        if (doctorId == null || doctorId.isEmpty()) {
            doctorId = "";
        } else {
            doctor = doctorService.findByUserId(Long.parseLong(doctorId));
        }

        if (specialityName == null || specialityName.isEmpty()) {
            specialityName = "";
        }
        List<Doctor> doctors = doctorService.findAllBySpecialityOrderByNameAsc(speciality);


        modelMap.put("specialities", specialities);
        modelMap.put("user_logged", userLogged);
        modelMap.put("doctors", doctors);
        modelMap.put("search_speciality", specialityName);
        modelMap.put("search_doctor", doctorId);


        return "patient-receptionist/waitingAppointment";
    }
}
