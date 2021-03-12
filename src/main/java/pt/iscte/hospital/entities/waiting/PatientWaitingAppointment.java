package pt.iscte.hospital.entities.waiting;

import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Patient;

import javax.persistence.*;

@Entity
public class PatientWaitingAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PatientWaitingAppointmentId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public PatientWaitingAppointment(){}

    public PatientWaitingAppointment(Doctor doctor, Patient patient){
        this.doctor = doctor;
        this.patient = patient;
    }
}
