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
    private Long invoiceId;
    private Long appointmentId;
    private Long receptionistId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Double value;
    private Boolean isPaid;

    // Constructors
    public Invoice() {
    }

    public Invoice(Long invoiceId,
                   Long appointmentId,
                   Long receptionistId,
                   Date date, Double value, Boolean isPaid) {
        this.invoiceId = invoiceId;
        this.appointmentId = appointmentId;
        this.receptionistId = receptionistId;
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

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(Long receptionistId) {
        this.receptionistId = receptionistId;
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
                ", appointmentId=" + appointmentId +
                ", receptionistId=" + receptionistId +
                ", date=" + date +
                ", value=" + value +
                ", isPaid=" + isPaid +
                '}';
    }
}
