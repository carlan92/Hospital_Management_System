package pt.iscte.hospital.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pt.iscte.hospital.entities.states.InvoiceState;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Invoice {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String invoiceApiId;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dueDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime issuedDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime paidDate;

    private double value;
    private int invoiceState;


    // Constructors
    public Invoice() {
        this.invoiceState = InvoiceState.NAO_FACTURADA.getStateNr();
    }

    public Invoice(Long invoiceId) {
        this.invoiceId = invoiceId;
        this.invoiceState = InvoiceState.NAO_FACTURADA.getStateNr();
    }

    // Methods



    public Appointment getAppointment() {
        return appointment;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(int invoiceState) {
        this.invoiceState = invoiceState;
    }

}