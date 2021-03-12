package pt.iscte.hospital.repositories.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.waiting.DoctorWaitingPatient;

@Repository
public interface DoctorWaitingPatientRepository extends JpaRepository<DoctorWaitingPatient, Long> {
}
