package pt.iscte.hospital.repositories.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

import java.util.List;

@Repository
public interface PatientWaitingAppointmentRepository extends JpaRepository<PatientWaitingAppointment, Long> {
    List<PatientWaitingAppointment> findAll();

}
