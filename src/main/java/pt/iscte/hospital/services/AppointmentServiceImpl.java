package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
