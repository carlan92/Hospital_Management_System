package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Patient;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
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

    List<Appointment> findAllByPatientUserIdAndSlotDateAndAppointmentStatusAndHasChecked(Long userId,
                                                                     LocalDate date,
                                                                     Integer appointmentStatus,
                                                                     boolean hasCheckedIn);

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

