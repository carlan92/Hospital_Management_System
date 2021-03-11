package pt.iscte.hospital.entities.waiting;

import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Doctor;

import javax.persistence.*;

@Entity
public class DoctorWaitingPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DoctorWaitingPatientId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    // Constructors
    public DoctorWaitingPatient() {
    }
}
