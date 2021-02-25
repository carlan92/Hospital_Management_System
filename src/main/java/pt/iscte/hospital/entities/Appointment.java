package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;


public class Appointment {
    // Attributes
    @Id
    @GeneratedValue
    private Long appointmentId;
    private Long slotId;
    private Long patientId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Time timeBegin;
    private Time timeEnd;
    private String notes;

    // Constructors
    public Appointment() {
    }

    public Appointment(Long appointmentId,
                       Long slotId,
                       Long patientId,
                       Date date, Time timeBegin, Time timeEnd, String notes) {
        this.appointmentId = appointmentId;
        this.slotId = slotId;
        this.patientId = patientId;
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

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "idAppointment=" + appointmentId +
                ", slotId=" + slotId +
                ", patientId=" + patientId +
                ", date=" + date +
                ", hourBegin=" + timeBegin +
                ", hourEnd=" + timeEnd +
                ", notes='" + notes + '\'' +
                '}';
    }
}
