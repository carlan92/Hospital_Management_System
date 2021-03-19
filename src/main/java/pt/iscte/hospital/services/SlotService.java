package pt.iscte.hospital.services;

import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.objects.utils.Day;
import pt.iscte.hospital.objects.utils.TimeInterval;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public interface SlotService {
    void saveSlot(Slot slot);

    List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, LocalDate date);

    List<Slot> findAllByDoctorAndIsAvailableOrderByTimeBeginAsc(
            Doctor doctor,
            boolean isAvailable);

    List<Slot> findAllByDoctorAndIsAvailableAndDateOrderByTimeBeginAsc(
            Doctor doctor,
            boolean isAvailable,
            LocalDate date);

    List<Slot> findAll(Sort sort);

    Long countByDoctorAndDate(Doctor doctor, LocalDate date);

    Long countByDoctorAndIsAvailableAndDate(Doctor doctor, boolean isAvailable, LocalDate date);

    Long countByDoctorSpecialityNameAndDate(String specialityName, LocalDate date);

    Long countByDoctorSpecialityNameAndIsAvailableAndDate(String specialityName, boolean isAvailable, LocalDate date);

    Slot findBySlotId(Long slotId);

    void generateSlots(int duration,
                       List<TimeInterval> timeIntervalList,
                       List<DayOfWeek> weekDaysList,
                       int year,
                       int month,
                       List<Doctor> doctors);

    List<Day> calendarColor(List<Day> calendar, Doctor doctor);

    List<Day> calendarColor(List<Day> calendar, String specialityName);

    boolean hasDisponibilidadeNoMes(List<Day> calendar, Doctor doctor);

    boolean hasDisponibilidadeNoDia(LocalDate day, Doctor doctor);

    Long countAllByIsAvailableAndDoctorSpecialityAndDateBetween(boolean isAvailable,
                                                  Speciality speciality,
                                                  LocalDate dateBegin,
                                                  LocalDate dateEnd);

    Long countAllByIsAvailableAndDoctorAndDateBetween(boolean isAvailable,
                                        Doctor doctor,
                                        LocalDate dateBegin,
                                        LocalDate dateEnd);
}
