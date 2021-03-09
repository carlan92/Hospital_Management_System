package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.states.AppointmentState;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findAllByAppointmentStatus(Integer appointmentStatus);
}
