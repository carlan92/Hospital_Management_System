package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;

import java.util.Date;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, Date date);
}
