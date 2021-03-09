package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;
import pt.iscte.hospital.objects.utils.Calendar;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Slot {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private LocalTime timeBegin;
    private LocalTime timeEnd;

    @OneToOne(mappedBy = "slot")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    private boolean isAvailable = true;

    // Constructors
    public Slot() {
    }

    public Slot(Long slotId, Doctor doctor, LocalDate date, LocalTime timeBegin, LocalTime timeEnd) {
        this.slotId = slotId;
        this.doctor = doctor;
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

    public LocalDate getDate() {
        return date;
    }

    public String getDateStr() {
        return date.format(Calendar.FORMATTER);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(LocalTime timeBegin) {
        this.timeBegin = timeBegin;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", date=" + date +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                ", doctor= " + doctor.getFirstAndLastName() +
                '}';
    }
}
