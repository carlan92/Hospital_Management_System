package pt.iscte.hospital.repositories.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.waiting.DoctorWaitingPatient;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorWaitingPatientRepository extends JpaRepository<DoctorWaitingPatient, Long> {
    List<DoctorWaitingPatient> findAllByDate(LocalDate date);
}
