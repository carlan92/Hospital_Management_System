package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;
import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import static pt.iscte.hospital.objects.utils.Calendar.*;

@Entity
public class Slot implements Comparable<Slot> {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Long slotId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private LocalTime timeBegin;
    private LocalTime timeEnd;


    @OneToMany(mappedBy = "slot")
    private Set<Appointment> appointments;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "slot")
    private Set<PatientWaitingAppointment> patientWaitingAppointments;

    private boolean isAvailable = true;

    // Constructors
    public Slot() {
    }

    public Slot(Doctor doctor, LocalDate date, LocalTime timeBegin, LocalTime timeEnd) {
        this.doctor = doctor;
        this.date = date;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    // Construtor cópia
    public Slot(Slot slot, boolean isAvailable) {
        this.doctor = slot.getDoctor();
        this.date = slot.getDate();
        this.timeBegin = slot.getTimeBegin();
        this.timeEnd = slot.getTimeEnd();
        this.isAvailable = isAvailable;
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
        return date.format(FORMATTER);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTimeBegin() {
        return timeBegin;
    }

    public String getTimeBeginStr() {
        return timeBegin.format(TIME_FORMATTER);
    }

    public void setTimeBegin(LocalTime timeBegin) {
        this.timeBegin = timeBegin;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public String getTimeEndStr() {
        return timeEnd.format(TIME_FORMATTER);
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

    @Override
    public int compareTo(Slot o) {
        if (this.date.isBefore(o.date)) {
            return -1;
        } else if (this.date.isAfter(o.date)) {
            return 1;
        } else {
            // Same date
            if (this.timeBegin.isBefore(o.timeBegin)) {
                return -1;
            } else if (this.timeBegin.isAfter(o.timeBegin)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
