package pt.iscte.hospital.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.entities.waiting.DoctorWaitingPatient;
import pt.iscte.hospital.objects.utils.Calendar;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
public class Appointment implements Comparable<Appointment> {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private LocalTime timeBegin;
    private LocalTime timeEnd;
    private LocalTime timeOfArrival;
    private Boolean hasChecked = false;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "appointment")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    private int appointmentStatus;

    @OneToOne(mappedBy = "appointment")
    private DoctorWaitingPatient doctorWaitingPatient;

    // Constructors
    public Appointment() {
    }

    public Appointment(Patient patient, Slot slot) {
        this.patient = patient;
        this.slot = slot;
        this.appointmentStatus = AppointmentState.MARCADA.getStateNr();
    }

    public Appointment(LocalDate date, LocalTime timeBegin, LocalTime timeEnd, String notes) {
        this.date = date;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.notes = notes;
    }


    // Methods
    public Long getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return this.slot.getDoctor();
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
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

    public LocalTime getTimeOfArrival() {
        return timeOfArrival;
    }

    public String getTimeOfArrivalStr() {
        if (timeOfArrival == null) {
            return "";
        }
        return timeOfArrival.format(Calendar.TIME_FORMATTER);
    }

    public void setTimeOfArrival(LocalTime timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public Boolean getHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(Boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAppointmentStatus() {
        return appointmentStatus;
    }

    public String getAppointmentStatusStr() {
        return AppointmentState.searchState(appointmentStatus);
    }

    public void setAppointmentStatus(int appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public DoctorWaitingPatient getDoctorWaitingPatient() {
        return doctorWaitingPatient;
    }

    public void setDoctorWaitingPatient(DoctorWaitingPatient doctorWaitingPatient) {
        this.doctorWaitingPatient = doctorWaitingPatient;
    }

    public boolean missedAppointment() {
        int missedAppointmentNr = AppointmentState.NAO_REALIZADA.getStateNr();
        return appointmentStatus == missedAppointmentNr;
    }

    public boolean hasInvoice(){
        return invoice != null;
    }

    public boolean foiRealizada(){
        return appointmentStatus == AppointmentState.REALIZADA.getStateNr();
    }


    @Override
    public int compareTo(Appointment o) {
        return this.getSlot().compareTo(o.getSlot());
    }
}
