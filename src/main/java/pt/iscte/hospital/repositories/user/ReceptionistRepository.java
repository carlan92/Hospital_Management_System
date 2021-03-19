package pt.iscte.hospital.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.hospital.entities.Receptionist;

import java.util.List;

public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
    List<Receptionist> findAll();
}
