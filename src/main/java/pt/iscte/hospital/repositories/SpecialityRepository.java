package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Speciality;

@Repository
public interface SpecialityRepository  extends JpaRepository<Speciality,Long> {

    public Speciality findByName(String name);
}
