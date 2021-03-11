package pt.iscte.hospital.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Patient;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository <Patient,Long>{
    Patient findByName(String name);
    Patient findByEmail(String email);
    Patient findByUsername(String username);
    Patient findByUserId(Long patientId);
    List<Patient> findAllByNameContainingIgnoreCase(String name);

}
