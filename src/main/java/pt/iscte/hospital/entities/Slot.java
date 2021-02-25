package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class Slot {
    // Attributes
    @Id
    @GeneratedValue
    private Long idSlot;
    private Long idDoctor;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Time timeBegin;
    private Time timeEnd;

    // Constructor
    public Slot(Long idSlot, Long idDoctor, Date date, Time timeBegin, Time timeEnd) {
        this.idSlot = idSlot;
        this.idDoctor = idDoctor;
        this.date = date;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    // Methods
    public Long getIdSlot() {
        return idSlot;
    }

    public void setIdSlot(Long idSlot) {
        this.idSlot = idSlot;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
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

    @Override
    public String toString() {
        return "Slot{" +
                "idSlot=" + idSlot +
                ", idDoctor=" + idDoctor +
                ", date=" + date +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
