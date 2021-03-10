package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Appointment;
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


}
