package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.UnitResponsible;

@Repository
public interface UnitResponsibleRepository  extends JpaRepository<UnitResponsible,Long> {
}
