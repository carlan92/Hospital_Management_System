package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
