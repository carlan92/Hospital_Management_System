package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
