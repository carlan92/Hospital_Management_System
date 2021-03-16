package pt.iscte.hospital.controllers.patient_receptionist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Invoice;
import pt.iscte.hospital.entities.User;

import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.services.invoice.InvoiceService;
import pt.iscte.hospital.services.user.UserService;

@Controller
public class InvoiceController {

    @Autowired
    UserService userService;
    @Autowired
    InvoiceService invoiceService;

    @GetMapping(value = "/patient-receptionist/invoice/{invoiceNr}")
    public String pageShowInvoice(ModelMap modelMap, @PathVariable (value = "invoiceNr") Long invoiceNr) {
        User userLogged = userService.currentUser();
        Invoice invoice =  invoiceService.findByInvoiceId(invoiceNr);
        Appointment appointment= invoice.getAppointment();


        modelMap.put("user_logged", userLogged);
        modelMap.put("invoice", invoice);
        modelMap.put("appointment", appointment);
        return "patient-receptionist/invoice";
    }
}
