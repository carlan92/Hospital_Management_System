package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
}
