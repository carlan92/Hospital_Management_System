package pt.iscte.hospital.entities.waiting;

import org.springframework.format.annotation.DateTimeFormat;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Patient;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime date;

    private boolean closed;

    public PatientWaitingAppointment() {
    }

    public PatientWaitingAppointment(LocalDateTime date, Doctor doctor, Patient patient) {
        this.date=date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getPatientWaitingAppointmentId() {
        return PatientWaitingAppointmentId;
    }

    public void setPatientWaitingAppointmentId(Long patientWaitingAppointmentId) {
        PatientWaitingAppointmentId = patientWaitingAppointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public int compareTo(PatientWaitingAppointment o) {
        return date.compareTo(o.date);
    }
}
