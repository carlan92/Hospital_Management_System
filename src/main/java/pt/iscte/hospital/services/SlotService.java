package pt.iscte.hospital.services;

import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.objects.utils.Day;
import pt.iscte.hospital.objects.utils.TimeInterval;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface SlotService {
    void saveSlot(Slot slot);
    List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, LocalDate date);
    List<Slot> findAllByDoctorAndIsAvailableAndDateOrderByTimeBeginAsc(Doctor doctor, boolean isAvailable,LocalDate date);
    List<Slot> findAll(Sort sort);
    Long countByDoctorAndDate(Doctor doctor, LocalDate date);
    Long countByDoctorAndIsAvailableAndDate(Doctor doctor, boolean isAvailable,LocalDate date);
    Slot findBySlotId(Long slotId);
    void generateSlots(int duration,
                       List<TimeInterval> timeIntervalList,
                       List<DayOfWeek> weekDaysList,
                       int year,
                       int month);
    List<Day> calendarColor(List<Day> calendar, Doctor doctor);
}
