package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;
import pt.iscte.hospital.entities.states.InvoiceState;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name="receptionist_id")
    private Receptionist receptionist;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Double value;

    private int invoiceState;


    // Constructors
    public Invoice() {
        this.invoiceState = InvoiceState.NAO_FACTURADA.getStateNr();
    }

    public Invoice(Long invoiceId, Date date, Double value) {
        this.invoiceId = invoiceId;
        this.date = date;
        this.value = value;
        this.invoiceState = InvoiceState.NAO_FACTURADA.getStateNr();
    }

    // Methods
    public Long getInvoiceId() {
        return invoiceId;
    }


    public Appointment getAppointment() {
        return appointment;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", appointment=" + appointment +
                ", receptionist=" + receptionist +
                ", date=" + date +
                ", value=" + value +
                ", invoiceState=" + invoiceState +
                '}';
    }
}
