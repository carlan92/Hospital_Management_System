package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Receptionist;

@Repository
public interface ReceptionistRepository  extends JpaRepository<Receptionist,Long> {
}
