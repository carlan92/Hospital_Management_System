package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {
    // Attributes
    @Id
    @GeneratedValue
    private Long invoiceId;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @OneToOne
    @JoinColumn(name = "receptionist_id")
    private Receptionist receptionist;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Double value;
    private Boolean isPaid;

    // Constructors
    public Invoice() {
    }

    public Invoice(Long invoiceId, Date date, Double value, Boolean isPaid) {
        this.invoiceId = invoiceId;
        this.date = date;
        this.value = value;
        this.isPaid = isPaid;
    }

    // Methods
    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    /*public Long getAppointment() {
        return appointment;
    }*/

    public void setAppointment(Long appointmentId) {
        this.appointment = appointment;
    }

    /*public Long getReceptionist() {
        return receptionist;
    }*/

    public void setReceptionist(Long receptionistId) {
        this.receptionist = receptionist;
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

    public Boolean isPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", date=" + date +
                ", value=" + value +
                ", isPaid=" + isPaid +
                '}';
    }
}
