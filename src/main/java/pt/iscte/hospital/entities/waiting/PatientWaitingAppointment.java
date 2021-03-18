package pt.iscte.hospital.entities.waiting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.Slot;
import pt.iscte.hospital.objects.utils.Calendar;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PatientWaitingAppointment implements Comparable<PatientWaitingAppointment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientWaitingAppointmentId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime limitDateToReply;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    private boolean closed;

    private boolean slotAccepted;

    private Long position;

    public PatientWaitingAppointment() {
    }

    public PatientWaitingAppointment(LocalDateTime date, Doctor doctor, Patient patient) {
        this.date=date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getPatientWaitingAppointmentId() {
        return patientWaitingAppointmentId;
    }

    public void setPatientWaitingAppointmentId(Long patientWaitingAppointmentId) {
        this.patientWaitingAppointmentId = patientWaitingAppointmentId;
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

    public Long getPosition() {
        return position;
    }
    public void setPosition(Long position) {
        this.position = position;
    }

    public String getDateTimeStr(){
        return date.format(Calendar.DATE_TIME_FORMATTER);
    }

    @Override
    public int compareTo(PatientWaitingAppointment o) {
        return date.compareTo(o.date);
    }
}
