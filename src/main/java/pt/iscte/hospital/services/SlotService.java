package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;

import java.util.Date;
import java.util.List;

public interface SlotService {
    List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, Date date);
}
