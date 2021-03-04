package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findAllBySpeciality(Speciality speciality);
}
