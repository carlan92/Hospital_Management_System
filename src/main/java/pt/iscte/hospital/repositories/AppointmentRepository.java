package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Invoice;
import pt.iscte.hospital.entities.Patient;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByAppointmentId(Long appointmentId);

    List<Appointment> findAllByAppointmentStatus(Integer appointmentStatus);

    // Patient Filters
    List<Appointment> findAllByPatientUserId(
            Long userId);

    List<Appointment> findAllByPatientAndAppointmentStatus(
            Patient patient,
            Integer appointmentStatus);

    List<Appointment> findAllByPatientUserIdAndAppointmentStatusAndSlotDateAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(
            Long userId,
            Integer appointmentStatus,
            LocalDate date,
            String doctorName,
            String specialityName);

    List<Appointment> findAllByPatientUserIdAndAppointmentStatusAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(
            Long userId,
            Integer appointmentStatus,
            String doctorName,
            String specialityName);

    List<Appointment> findAllByPatientUserIdAndSlotDateAndAppointmentStatusAndHasChecked(
            Long userId,
            LocalDate date,
            Integer appointmentStatus,
            boolean hasCheckedIn);

    List<Appointment> findAllByPatientUserIdAndSlotDateAndAppointmentStatus(
            Long userId,
            LocalDate date,
            Integer appointmentStatus);

    List<Appointment> findAllBySlotDateAndAppointmentStatus(LocalDate date, Integer appointmentStatus);

    List<Appointment> findAll();

    // Doctor Filters
    List<Appointment> findAllBySlotDoctorUserId(Long userId);

    List<Appointment> findAllByPatientNameContainingIgnoreCaseAndSlotDoctorUserId(
            String patientName,
            Long userId);

    List<Appointment> findAllBySlotDateAndPatientNameContainingIgnoreCaseAndSlotDoctorUserId(
            LocalDate date,
            String patientName,
            Long userId);

    List<Appointment> findAllBySlotDoctorUserIdAndAppointmentStatus(
            Long doctorId,
            int appointmentStatus);

    // Receptionist Filters
    List<Appointment> findAllBySlotDateAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(
            LocalDate date,
            String doctorName,
            String patientName,
            String specialityName);

    List<Appointment> findAllBySlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(
            String doctorName,
            String patientName,
            String specialityName);

    List<Appointment> findAllBySlotDateAndAppointmentStatusAndSlotDoctorSpecialityNameContainingIgnoreCaseAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCase(
            LocalDate date,
            Integer appointmentStatus,
            String specialityName,
            String doctorName,
            String patientName);


    // Gest??o das consultas (M??dico)
    List<Appointment> findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasCheckedOrderBySlotTimeBeginAsc(
            Long userId,
            LocalDate date,
            int appointmentState,
            boolean hasChecked);

    List<Appointment> findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusOrderBySlotTimeBeginAsc(
            Long userId,
            LocalDate date,
            int appointmentState
    );

    // Verificar n??mero de utentes com consulta e que nao compareceram
    long countBySlotDateAndAppointmentStatus(
            LocalDate date,
            int appointmentState);


    // Verificar n??mero de utentes com consulta com check in efetuado para o dia de hoje
    long countBySlotDateAndAppointmentStatusAndHasChecked (
            LocalDate date,
            int appointmentState,
            boolean hasChecked);

    // Verificar n??mero de consultas de um utente com um m??dico
    long countBySlotDoctorUserIdAndPatientUserIdAndAppointmentStatus(
            Long doctorId,
            Long patientId,
            int appointmentState
    );

    // Contagens para a p??gina main do doctor
    long countBySlotDoctorUserIdAndSlotDateAndAppointmentStatus(
            long doctorId,
            LocalDate date,
            int appointmentState);

    long countBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasChecked(
            long doctorId,
            LocalDate date,
            int appointmentState,
            boolean hasChecked);

    // Thread
    List<Appointment> findAllByAppointmentStatusAndInvoice(int appointmentStatus, Invoice invoice);
}

