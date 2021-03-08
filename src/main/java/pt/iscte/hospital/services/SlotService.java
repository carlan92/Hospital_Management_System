package pt.iscte.hospital.services;

import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.objects.utils.TimeInterval;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SlotService {
    void addSlot(Slot slot);
    List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, LocalDate date);
    List<Slot> findAll(Sort sort);
    void generateSlots(int duration,
                       List<TimeInterval> timeIntervalList,
                       List<DayOfWeek> weekDaysList,
                       int year,
                       int month);
}
