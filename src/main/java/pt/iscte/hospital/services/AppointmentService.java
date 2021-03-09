package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Patient;

import java.util.List;

public interface AppointmentService {
    void saveAppointment(Appointment appointment);
    List<Appointment> findAllByAppointmentStatus(Integer appointmentStatus);
    List<Appointment> findAllByPatientAndAppointmentStatus(Patient patient, Integer appointmentStatus);
}
