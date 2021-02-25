package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Invoice {
    // Attributes
    @Id
    @GeneratedValue
    private Long idInvoice;
    private Long idAppointment;
    private Long idReceptionist;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Double value;
    private Boolean isPaid;

    // Constructor
    public Invoice(Long idInvoice,
                   Long idAppointment,
                   Long idReceptionist,
                   Date date, Double value, Boolean isPaid) {
        this.idInvoice = idInvoice;
        this.idAppointment = idAppointment;
        this.idReceptionist = idReceptionist;
        this.date = date;
        this.value = value;
        this.isPaid = isPaid;
    }

    // Methods
    public Long getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Long idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public Long getIdReceptionist() {
        return idReceptionist;
    }

    public void setIdReceptionist(Long idReceptionist) {
        this.idReceptionist = idReceptionist;
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
                "idInvoice=" + idInvoice +
                ", idAppointment=" + idAppointment +
                ", idReceptionist=" + idReceptionist +
                ", date=" + date +
                ", value=" + value +
                ", isPaid=" + isPaid +
                '}';
    }
}
