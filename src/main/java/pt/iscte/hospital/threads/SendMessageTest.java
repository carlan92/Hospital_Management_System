package pt.iscte.hospital.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.AppointmentService;
import pt.iscte.hospital.services.MessageService;
import pt.iscte.hospital.services.user.UserService;


@Component
public class SendMessageTest {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;

    // Verifica todas as consultas sem factura e solicita factura
   @Scheduled(fixedRate = 10000000)
    public void sendMessages() {
        User user1 = userService.findByUserId(100L); // Médico 111
        User user2 = userService.findByUserId(215L); // Utente Ana Ribeiro
        User user3 = userService.findByUserId(386L); // Rececionista

        Message msg11 = new Message("Bem vinda Dra!","Desejamos muitos sucessos", user1);
        Message msg12 = new Message("Vagas","Oh! Não tem mais vagas para os seus utentes :(", user1);

        Message msg21 = new Message("Bem vindo Rececionista!","Desejamos muito sucesso", user2);
        Message msg22 = new Message("Trabalho","Cuidado com os atrasos, sorria para os clientes!", user2);

        Message msg31 = new Message("Bem vinda Cara Utente!","Desejamos muito sucesso na nossa companhia", user3);
        Message msg32 = new Message("Peças","Estamos com 25% desconto em todas as peças e órgãos!", user3);
        Message msg33 = new Message("Peças","Spam... por favor apague <a href='https://www.publico.pt'>clique aqui</a>", user3);
        Message msg34 = new Message("Peças","Spam... por favor apague <a href='https://www.publico.pt'>clique aqui</a>", user3);
        Message msg35 = new Message("Peças","Spam... por favor apague <a href='https://www.publico.pt'>clique aqui</a>", user3);
        Message msg36 = new Message("Peças","Spam... por favor apague <a href='https://www.publico.pt'>clique aqui</a>", user3);

        /*messageService.save(msg11);
        messageService.save(msg12);

        messageService.save(msg21);
        messageService.save(msg22);

        messageService.save(msg31);
        messageService.save(msg32);
        messageService.save(msg33);
        messageService.save(msg34);
        messageService.save(msg35);
        messageService.save(msg36);*/

        System.out.println("Mensagens criadas!");
    }
}
