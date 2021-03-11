package pt.iscte.hospital.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByUserId(Long doctorId);
    List<Doctor> findAllBySpeciality(Speciality speciality);
    List<Doctor> findAllBySpecialityOrderByNameAsc(Speciality speciality);
    List<Doctor> findAllByNameContainingIgnoreCase(String name);
    List<Doctor> findAllByNameContainingIgnoreCaseAndSpeciality(String name, Speciality speciality);
}
