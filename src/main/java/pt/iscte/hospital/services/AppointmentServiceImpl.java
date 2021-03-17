package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Invoice;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.repositories.AppointmentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;


    // Methods
    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findByAppointmentId(Long appointmentId) {
        return appointmentRepository.findByAppointmentId(appointmentId);
    }

    @Override
    public List<Appointment> findAllByAppointmentStatus(Integer appointmentStatus) {
        return appointmentRepository.findAllByAppointmentStatus(appointmentStatus);
    }

    @Override
    public List<Appointment> findAllByPatientUserId(Long userId){
        return appointmentRepository.findAllByPatientUserId(userId);
    }

    @Override
    public List<Appointment> findAllByPatientAndAppointmentStatus(Patient patient, Integer appointmentStatus) {
        return appointmentRepository.findAllByPatientAndAppointmentStatus(patient, appointmentStatus);
    }

    @Override
    public List<Appointment> findAllByPatientUserIdAndAppointmentStatusAndSlotDateAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(Long userId,
                                                                                                                                                                       Integer appointmentStatus,
                                                                                                                                                                       LocalDate date,
                                                                                                                                                                       String doctorName,
                                                                                                                                                                       String specialityName) {
        return appointmentRepository.findAllByPatientUserIdAndAppointmentStatusAndSlotDateAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(userId,
                appointmentStatus,
                date,
                doctorName,
                specialityName);
    }

    @Override
    public List<Appointment> findAllByPatientUserIdAndAppointmentStatusAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(Long userId,
                                                                                                                                                            Integer appointmentStatus,
                                                                                                                                                            String doctorName,
                                                                                                                                                            String specialityName) {
        return appointmentRepository.findAllByPatientUserIdAndAppointmentStatusAndSlotDoctorNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(userId,
                appointmentStatus,
                doctorName,
                specialityName);
    }

    @Override
    public List<Appointment> findAllByPatientUserIdAndSlotDateAndAppointmentStatusAndHasChecked(Long userId,
                                                                                                LocalDate date,
                                                                                                Integer appointmentStatus,
                                                                                                boolean hasChecked) {
        return appointmentRepository.findAllByPatientUserIdAndSlotDateAndAppointmentStatusAndHasChecked(userId,
                date,
                appointmentStatus,
                hasChecked);
    }

    @Override
    public List<Appointment> findAllByPatientUserIdAndSlotDateAndAppointmentStatus(Long userId,
                                                                                   LocalDate date,
                                                                                   Integer appointmentStatus) {
        return appointmentRepository.findAllByPatientUserIdAndSlotDateAndAppointmentStatus(userId,
                date,
                appointmentStatus);
    }

    @Override
    public List<Appointment> findAllBySlotDateAndAppointmentStatus(LocalDate date,
                                                                   Integer appointmentStatus) {
        return appointmentRepository.findAllBySlotDateAndAppointmentStatus(date, appointmentStatus);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findAllBySlotDoctorUserId(Long userId) {
        return appointmentRepository.findAllBySlotDoctorUserId(userId);
    }

    @Override
    public List<Appointment> findAllByPatientNameContainingIgnoreCaseAndSlotDoctorUserId(String patientName, Long userId) {
        return appointmentRepository.findAllByPatientNameContainingIgnoreCaseAndSlotDoctorUserId(patientName, userId);
    }

    @Override
    public List<Appointment> findAllBySlotDateAndPatientNameContainingIgnoreCaseAndSlotDoctorUserId(LocalDate date,
                                                                                                    String patientName,
                                                                                                    Long userId) {
        return appointmentRepository.findAllBySlotDateAndPatientNameContainingIgnoreCaseAndSlotDoctorUserId(date,
                patientName,
                userId);
    }

    @Override
    public List<Appointment> findAllBySlotDateAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(LocalDate date,
                                                                                                                                                                     String doctorName,
                                                                                                                                                                     String patientName,
                                                                                                                                                                     String specialityName) {
        return appointmentRepository.findAllBySlotDateAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(date,
                doctorName,
                patientName,
                specialityName);
    }

    @Override
    public List<Appointment> findAllBySlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(String doctorName,
                                                                                                                                                          String patientName,
                                                                                                                                                          String specialityName) {
        return appointmentRepository.findAllBySlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCaseAndSlotDoctorSpecialityNameContainingIgnoreCase(doctorName,
                patientName,
                specialityName);
    }

    @Override
    public List<Appointment> findAllBySlotDateAndAppointmentStatusAndSlotDoctorSpecialityNameContainingIgnoreCaseAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCase(
            LocalDate date,
            Integer appointmentStatus,
            String specialityName,
            String doctorName,
            String patientName) {
        return appointmentRepository.findAllBySlotDateAndAppointmentStatusAndSlotDoctorSpecialityNameContainingIgnoreCaseAndSlotDoctorNameContainingIgnoreCaseAndPatientNameContainingIgnoreCase(
                date,
                appointmentStatus,
                specialityName,
                doctorName,
                patientName);
    }

    // Gestão das consultas (Médico)
    @Override
    public List<Appointment> findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasCheckedOrderBySlotTimeBeginAsc(
            Long userId,
            LocalDate date,
            int appointmentState,
            boolean hasChecked) {
        return appointmentRepository.findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasCheckedOrderBySlotTimeBeginAsc(
                userId,
                date,
                appointmentState,
                hasChecked);
    }

    @Override
    public List<Appointment> findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusOrderBySlotTimeBeginAsc(
            Long userId,
            LocalDate date,
            int appointmentState) {
        return appointmentRepository.findAllBySlotDoctorUserIdAndSlotDateAndAppointmentStatusOrderBySlotTimeBeginAsc(
                userId,
                date,
                appointmentState);
    }
    @Override
    public List<Appointment> findAllBySlotDoctorUserIdAndAppointmentStatus(Long doctorId, int appointmentStatus){
        return appointmentRepository.findAllBySlotDoctorUserIdAndAppointmentStatus(doctorId, appointmentStatus);
    }

    // Verificar número de utentes com consulta e que nao compareceram
    @Override
    public long countBySlotDateAndAppointmentStatus(
            LocalDate date,
            int appointmentState) {
        return appointmentRepository.countBySlotDateAndAppointmentStatus(
                date,
                appointmentState);
    }
    // Verificar número de utentes com consulta com check in efetuado para o dia de hoje
    @Override
    public long countBySlotDateAndAppointmentStatusAndHasChecked(
            LocalDate date,
            int appointmentState,
            boolean hasChecked) {
        return appointmentRepository.countBySlotDateAndAppointmentStatusAndHasChecked(
                date,
                appointmentState,
                hasChecked);
    }

    // Verificar número de consultas de um utente com um médico
    @Override
    public long countBySlotDoctorUserIdAndPatientUserIdAndAppointmentStatus(
            Long doctorId,
            Long patientId,
            int appointmentState) {
        return appointmentRepository.countBySlotDoctorUserIdAndPatientUserIdAndAppointmentStatus(
                doctorId,
                patientId,
                appointmentState);
    }

    // Contagens para a página main do doctor
    public long countBySlotDoctorUserIdAndSlotDateAndAppointmentStatus(
            long doctorId,
            LocalDate date,
            int appointmentState) {
        return appointmentRepository.countBySlotDoctorUserIdAndSlotDateAndAppointmentStatus(
                doctorId,
                date,
                appointmentState);
    }

    public long countBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasChecked(
            long doctorId,
            LocalDate date,
            int appointmentState,
            boolean hasChecked) {
        return appointmentRepository.countBySlotDoctorUserIdAndSlotDateAndAppointmentStatusAndHasChecked(
                doctorId,
                date,
                appointmentState,
                hasChecked);
    }

    // Thread
    @Override
    public List<Appointment> findAllByAppointmentStatusAndInvoice(int appointmentStatus, Invoice invoice){
        return appointmentRepository.findAllByAppointmentStatusAndInvoice(appointmentStatus, invoice);
    }
}
