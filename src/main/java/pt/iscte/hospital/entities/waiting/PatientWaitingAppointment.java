package pt.iscte.hospital.entities.waiting;

import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Patient;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class PatientWaitingAppointment implements Comparable<PatientWaitingAppointment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PatientWaitingAppointmentId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime dateTimeRequest;

    private boolean closed;

    public PatientWaitingAppointment() {
    }

    public PatientWaitingAppointment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    @Override
    public int compareTo(PatientWaitingAppointment o) {
        return dateTimeRequest.compareTo(o.dateTimeRequest);
    }
}
