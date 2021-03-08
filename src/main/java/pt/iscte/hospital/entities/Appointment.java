package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Appointment {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Time timeBegin;
    private Time timeEnd;
    private Boolean hasCheckedIn = false;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "appointment")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    private int AppointmentStatus;

    // Constructors
    public Appointment() {
    }

    public Appointment(Date date, Time timeBegin, Time timeEnd, String notes) {
        this.date = date;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.notes = notes;
    }


    // Methods
    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Time timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Boolean getHasCheckedIn() {
        return hasCheckedIn;
    }

    public void setHasCheckedIn(Boolean hasCheckedIn) {
        this.hasCheckedIn = hasCheckedIn;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAppointmentStatus(int appointmentStatus) {
        AppointmentStatus = appointmentStatus;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "idAppointment=" + appointmentId +
                ", date=" + date +
                ", hourBegin=" + timeBegin +
                ", hourEnd=" + timeEnd +
                ", notes='" + notes + '\'' +
                '}';
    }
}
