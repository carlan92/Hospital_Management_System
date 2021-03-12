package pt.iscte.hospital.repositories.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

@Repository
public interface PatientWaitingAppointmentRepository extends JpaRepository<PatientWaitingAppointment, Long> {

}
