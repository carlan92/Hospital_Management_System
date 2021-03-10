package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Patient;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    void saveAppointment(Appointment appointment);
    List<Appointment> findAllByAppointmentStatus(Integer appointmentStatus);

    // Patient Filters
    List<Appointment> findAllByPatientAndAppointmentStatus(Patient patient,
                                                           Integer appointmentStatus);

    List<Appointment> findAllByPatientUserIdAndAppointmentStatusAndSlotDateAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(Long userId,
                                                                                                                                                                Integer appointmentStatus,
                                                                                                                                                                LocalDate date,
                                                                                                                                                                String doctorName,
                                                                                                                                                                String specialityName);

    List<Appointment> findAllByPatientUserIdAndAppointmentStatusAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(Long userId,
                                                                                                                                                     Integer appointmentStatus,
                                                                                                                                                     String doctorName,
                                                                                                                                                     String specialityName);

    List<Appointment> findAllByPatientUserIdBySlotDateAndAppointmentStatusAndHasChecked(Long userId,
                                                                           LocalDate date,
                                                                           Integer appointmentStatus,
                                                                           boolean hasChecked);

    List<Appointment> findAll();

    // Doctor Filters
    List<Appointment> findAllBySlotDoctorUserId(Long userId);

    List<Appointment> findAllByPatientNameContainingIgnoreCaseAndSlotDoctorUserId(String patientName,
                                                                                  Long userId);

    List<Appointment> findAllBySlotDateAndPatientNameContainingIgnoreCaseAndSlotDoctorUserId(LocalDate date,
                                                                                             String patientName,
                                                                                             Long userId);

    // Receptionist Filters
    List<Appointment> findAllBySlotDateAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(LocalDate date,
                                                                                                                                                              String doctorName,
                                                                                                                                                              String patientName,
                                                                                                                                                              String specialityName);

    List<Appointment> findAllBySlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(String doctorName,
                                                                                                                                                   String patientName,
                                                                                                                                                   String specialityName);
}
