package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Nationality;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality,Long> {
    Nationality findByName(String name);
}
