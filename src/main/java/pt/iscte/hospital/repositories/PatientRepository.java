package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository <Patient,Long>{
    public Patient findByName(String name);
    public Patient findByEmail(String email);
    public Patient findByUsername(String username);

}
