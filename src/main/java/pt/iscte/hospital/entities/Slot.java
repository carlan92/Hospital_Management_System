package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Slot {
    // Attributes
    @Id
    @GeneratedValue
    private Long slotId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Time timeBegin;
    private Time timeEnd;

    @OneToOne(mappedBy = "slot")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    // Constructors
    public Slot() {
    }

    public Slot(Long slotId, Long doctorId, Date date, Time timeBegin, Time timeEnd) {
        this.slotId = slotId;
        this.date = date;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    // Methods
    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
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
                "slotId=" + slotId +
                ", date=" + date +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
