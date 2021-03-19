package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.ControlCreationSlot;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ControlCreationSlotRepository extends JpaRepository<ControlCreationSlot, Long> {
    List<ControlCreationSlot> findAllByDate(LocalDate date);

}
