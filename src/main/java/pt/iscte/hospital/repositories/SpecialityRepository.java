package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Speciality;

import java.util.List;

@Repository
public interface SpecialityRepository  extends JpaRepository<Speciality,Long> {

    Speciality findByName(String name);
    List<Speciality> findAll();
}
