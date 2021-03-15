package pt.iscte.hospital.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.repositories.AppointmentRepository;
import pt.iscte.hospital.services.AppointmentService;
import pt.iscte.hospital.services.invoice.InvoiceService;

import java.util.List;


@Component
public class UpdateInvoice {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    InvoiceService invoiceService;

    // Verifica todas as consultas sem factura e solicita factura
    @Scheduled(fixedRate = 60000)
    public void solicitarFacturas() {
        List<Appointment> appointments = appointmentService.findAllByAppointmentStatusAndInvoice(AppointmentState.REALIZADA.getStateNr(), null);

        System.out.println("Verificação de existência de facturas");

        for (Appointment appointment : appointments) {
            invoiceService.createInvoice(appointment);
            System.out.println("Tentativa de obter factura para: " + appointment.getPatient().getName() + " - " + appointment.getDoctor().getSpeciality().getName());
        }
    }
}
