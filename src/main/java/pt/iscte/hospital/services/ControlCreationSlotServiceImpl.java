package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.ControlCreationSlot;
import pt.iscte.hospital.repositories.ControlCreationSlotRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ControlCreationSlotServiceImpl {
    private final ControlCreationSlotRepository controlCreationSlotRepository;

    @Autowired
    public ControlCreationSlotServiceImpl(ControlCreationSlotRepository controlCreationSlotRepository) {
        this.controlCreationSlotRepository = controlCreationSlotRepository;
    }

    List<ControlCreationSlot> findAllByDate(LocalDate date) {
        return controlCreationSlotRepository.findAllByDate(date);
    }

    void save(ControlCreationSlot controlCreationSlot) {
        controlCreationSlotRepository.save(controlCreationSlot);
    }
}
