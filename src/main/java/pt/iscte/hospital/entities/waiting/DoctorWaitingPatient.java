package pt.iscte.hospital.entities.waiting;

import pt.iscte.hospital.entities.Appointment;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "doctor_waiting_patient")
public class DoctorWaitingPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private LocalDate date;
    private LocalTime timeFirstCall;
    private LocalTime timeLatestCall;

    @OneToOne
    @MapsId
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    // Constructors
    public DoctorWaitingPatient() {
    }

    public DoctorWaitingPatient(Appointment appointment) {
        this.date = LocalDate.now();
        this.timeFirstCall = LocalTime.now();
        this.timeLatestCall = LocalTime.now();
        this.appointment = appointment;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTimeFirstCall() {
        return timeFirstCall;
    }

    public LocalTime getTimeLatestCall() {
        return timeLatestCall;
    }

    public void setTimeLatestCall(LocalTime timeLatestCall) {
        this.timeLatestCall = timeLatestCall;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
