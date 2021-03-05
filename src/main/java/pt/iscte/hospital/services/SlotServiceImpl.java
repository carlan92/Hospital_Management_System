package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;
import pt.iscte.hospital.repositories.SlotRepository;

import java.util.Date;
import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, Date date){
        return slotRepository.findAllByDoctorAndDateOrderByTimeBeginAsc(doctor, date);
    }
}
