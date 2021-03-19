package pt.iscte.hospital.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.entities.Receptionist;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.services.MessageService;
import pt.iscte.hospital.services.SlotService;
import pt.iscte.hospital.services.SpecialityService;
import pt.iscte.hospital.services.user.DoctorService;
import pt.iscte.hospital.services.user.ReceptionistService;

import java.time.LocalDate;
import java.util.List;

@Component
public class VerificarVagas {
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ReceptionistService receptionistService;
    @Autowired
    private SlotService slotService;
    @Autowired
    private MessageService messageService;

    private final String MSG_RECEPTIONIST_DOCTOR = "Não existem vagas livres para %s %s, %s, para o mês corrente.";
    private final String MSG_RECEPTIONIST_SPECIALITY = "Não existem vagas livres para a especialidade %s, para o mês corrente.";
    private final String MSG_DOCTOR = "Tem todas as suas vagas preenchidas para o mês corrente";


    @Scheduled(fixedRate = 86400000) // A cada 24h faz verificação
    public void enviarMsgSemVagas() {
        List<Doctor> doctorList = doctorService.findAll();
        List<Speciality> specialityList = specialityService.findAll();

        LocalDate todayDate = LocalDate.now();
        LocalDate endMonthDate = LocalDate.now().withDayOfMonth(todayDate.lengthOfMonth());

        // Mensagens para médico sem vagas
        for (Doctor doctor : doctorList) {
            Long nrAvailableSlots = slotService.countAllByIsAvailableAndDoctorAndDateBetween(
                    true,
                    doctor,
                    todayDate,
                    endMonthDate);
            if (nrAvailableSlots == 0) {
                // enviar mensagem recepcionistas // enviar mensagem médico
                msgReceptionistsAndDoctor(doctor);
            }
        }

        // Mensagens para especialidade sem vagas
        for (Speciality speciality : specialityList) {
            Long nrAvailableSlots = slotService.countAllByIsAvailableAndDoctorSpecialityAndDateBetween(
                    true,
                    speciality,
                    todayDate,
                    endMonthDate);
            if (nrAvailableSlots == 0) {
                // enviar mensagem para os recepcionistas
                msgReceptionistsAboutSpeciality(speciality);
            }
        }
    }

    private void msgReceptionistsAndDoctor(Doctor doctor) {
        List<Receptionist> receptionistList = receptionistService.findAll();

        String artigo = "";
        if (doctor.getSex().equalsIgnoreCase("masculino")) {
            artigo = "o";
        } else {
            artigo = "a";
        }

        String nome = doctor.getTitleAndName();
        String especialidade = doctor.getSpeciality().getName();

        String msgReceptionist = String.format(MSG_RECEPTIONIST_DOCTOR, artigo, nome, especialidade);

        Message messageDoctor = new Message(
                "Vagas para o mês preenchidas",
                MSG_DOCTOR,
                doctor);
        messageService.save(messageDoctor);
        System.out.println("Enviada msg de indisponibilidade.");

        for (Receptionist receptionist : receptionistList) {


            Message messageReceptionist = new Message(
                    "Médico sem vagas para o mês",
                    msgReceptionist,
                    receptionist);
            messageService.save(messageReceptionist);
            System.out.println("Enviada msg de indisponibilidade.");
        }
    }

    private void msgReceptionistsAboutSpeciality(Speciality speciality) {
        List<Receptionist> receptionistList = receptionistService.findAll();

        String especialidade = speciality.getName();

        String msgReceptionist = String.format(MSG_RECEPTIONIST_SPECIALITY, especialidade);


        for (Receptionist receptionist : receptionistList) {
            Message messageReceptionist = new Message(
                    "Especialidade sem vagas para o mês",
                    msgReceptionist,
                    receptionist);
            messageService.save(messageReceptionist);
            System.out.println("Enviada msg de indisponibilidade.");
        }
    }

}
