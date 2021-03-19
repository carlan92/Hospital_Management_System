package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.ControlCreationSlot;

import java.time.LocalDate;
import java.util.List;

public interface ControlCreationSlotService {
    List<ControlCreationSlot> findAllByDate(LocalDate date);
    void save(ControlCreationSlot controlCreationSlot);
}
