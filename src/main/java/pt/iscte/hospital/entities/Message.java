package pt.iscte.hospital.entities;

import lombok.Getter;
import lombok.Setter;
import pt.iscte.hospital.objects.utils.Calendar;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Message {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private String subject;
    private String message;
    private LocalDate date;
    private LocalTime time;
    private boolean readMsg;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // Constructor
    public Message() {
        readMsg = false;
    }

    public Message(String subject, String message, User userReceiver) {
        this.subject = subject;
        this.message = message;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.user = userReceiver;
        readMsg = false;
    }

    // Methods
    public String getDateStr(){
        if(date == null){
            return "";
        }
        return date.format(Calendar.FORMATTER);
    }
}
