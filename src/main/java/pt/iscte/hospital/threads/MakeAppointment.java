package pt.iscte.hospital.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;
import pt.iscte.hospital.services.AppointmentService;
import pt.iscte.hospital.services.SlotService;
import pt.iscte.hospital.services.waiting.PatientWaitingAppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class MakeAppointment {
    private final String URL_CONFIRMA_SIM = "";
    private final String URL_CONFIRMA_NAO = "";

    @Autowired
    private PatientWaitingAppointmentService patientWaitingAppointmentService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private SlotService slotService;

    // Verifica todas as entradas da lista de espera e tenta marcar consultas para as vagas abertas
    //@Scheduled(fixedRate = 60000)
    public void marcarConsultasEmEspera() {
        System.out.println("Iniciado sistema de marcação de consultas em lista de espera.");
        LocalDateTime todayDateTime = LocalDateTime.now();

        // Verifica se à consultas em espera
        List<PatientWaitingAppointment> listaDeEspera = patientWaitingAppointmentService.findAllByClosedOrderByDate(false);


        // Para cada elemento em espera verifica se à vaga
        for (PatientWaitingAppointment patientWaiting : listaDeEspera) {
            Doctor doctor = patientWaiting.getDoctor();
            // Verifica lista de slot disponíveis
            List<Slot> slots = slotService.findAllByDoctorAndIsAvailableOrderByTimeBeginAsc(doctor, true);
            for (Slot slot : slots) {
                LocalDate slotDate = slot.getDate();
                LocalTime slotTime = slot.getTimeBegin();
                LocalDateTime slotDateTime = LocalDateTime.of(slotDate, slotTime);
                if(slotDateTime.isAfter(todayDateTime)){
                    slot.setAvailable(false);
                    slotService.saveSlot(slot);

                    patientWaiting.setClosed(true);
                    patientWaitingAppointmentService.save(patientWaiting);

                    Patient patient = patientWaiting.getPatient();

                    /*Appointment appointment = new Appointment(patient, slot);
                    appointmentService.saveAppointment(appointment);*/

                    Message message = new Message(
                            "Marcação de consulta",
                            "Por favor confirme se deseja a sua consulta com o {Drname}, {especialidade}, para a data" +
                                    "{data} às {horas}. Confirma: <a class=\"login-a\" href=\"/public/registration\">Sim</a>   <a class=\"login-a\" href=\"/public/registration\">Não</a>",
                            patient);
                    System.out.println("Consulta marcada!");
                    break;
                }
            }
        }


    }
}
