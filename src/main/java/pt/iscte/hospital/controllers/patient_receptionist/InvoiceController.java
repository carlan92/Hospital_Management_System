package pt.iscte.hospital.controllers.patient_receptionist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Invoice;
import pt.iscte.hospital.entities.User;

import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.exceptions.PaymentException;
import pt.iscte.hospital.objects.utils.AlertMessageImage;
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

    @GetMapping(value = "/patient-receptionist/invoice/pay/{invoiceNr}")
    public String pageShowPayInvoice(ModelMap modelMap, @PathVariable (value = "invoiceNr") Long invoiceNr) {
        User userLogged = userService.currentUser();
        Invoice invoice =  invoiceService.findByInvoiceId(invoiceNr);
        Appointment appointment= invoice.getAppointment();

        modelMap.put("user_logged", userLogged);
        modelMap.put("hasButton2", true);
        modelMap.put("button2_text","Regressar à factura");
        modelMap.put("button2_url","/patient-receptionist/invoice/"+ invoiceNr);

        try{
            invoiceService.payInvoice(appointment);

        }catch (PaymentException e){
            modelMap.put("message", "Não foi possível registar o pagamento na factura.");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
            return "components/alert-message";
        }
        modelMap.put("message", "Pagamento registado.");
        modelMap.put("imageURL", AlertMessageImage.SUCCESS.getImageURL());
        return "components/alert-message";
    }


}
