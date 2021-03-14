package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;
import pt.iscte.hospital.objects.utils.CalendarColor;
import pt.iscte.hospital.objects.utils.Day;
import pt.iscte.hospital.objects.utils.TimeInterval;
import pt.iscte.hospital.repositories.user.DoctorRepository;
import pt.iscte.hospital.repositories.SlotRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SlotRepository slotRepository;

    // Methods
    @Override
    public void saveSlot(Slot slot) {
        slotRepository.save(slot);
    }

    @Override
    public List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, LocalDate date) {
        return slotRepository.findAllByDoctorAndDateOrderByTimeBeginAsc(doctor, date);
    }

    @Override
    public List<Slot> findAllByDoctorAndIsAvailableAndDateOrderByTimeBeginAsc(
            Doctor doctor,
            boolean isAvailable,
            LocalDate date) {
        return slotRepository.findAllByDoctorAndIsAvailableAndDateOrderByTimeBeginAsc(doctor, isAvailable, date);
    }

    @Override
    public List<Slot> findAll(Sort sort) {
        return slotRepository.findAll(sort);
    }

    @Override
    public Slot findBySlotId(Long slotId) {
        return slotRepository.findBySlotId(slotId);
    }

    @Override
    public Long countByDoctorAndDate(Doctor doctor, LocalDate date) {
        return slotRepository.countByDoctorAndDate(doctor, date);
    }

    @Override
    public Long countByDoctorAndIsAvailableAndDate(Doctor doctor, boolean isAvailable, LocalDate date) {
        return slotRepository.countByDoctorAndIsAvailableAndDate(doctor, isAvailable, date);
    }

    @Override
    public Long countByDoctorSpecialityNameAndDate(
            String specialityName,
            LocalDate date) {
        return slotRepository.countByDoctorSpecialityNameAndDate(
                specialityName,
                date);
    }


    @Override
    public Long countByDoctorSpecialityNameAndIsAvailableAndDate(
            String specialityName,
            boolean isAvailable,
            LocalDate date) {
        return slotRepository.countByDoctorSpecialityNameAndIsAvailableAndDate(
                specialityName,
                isAvailable,
                date);
    }

    @Override
    public void generateSlots(int duration,
                              List<TimeInterval> timeIntervalList,
                              List<DayOfWeek> weekDaysList,
                              int year,
                              int month) {

        int nrDays = LocalDate.of(year, month, 1).lengthOfMonth(); // number of days in the month
        List<Doctor> doctors = doctorRepository.findAll();


        // For each day
        for (int day = 1; day <= nrDays; day++) {
            LocalDate slotDate = LocalDate.of(year, month, day);
            DayOfWeek dayOfWeek = slotDate.getDayOfWeek();
            System.out.println(day);

            // if the week day is available
            if (weekDaysList.contains(dayOfWeek)) {
                // for each doctor
                for (Doctor doctor : doctors) {

                    for (TimeInterval timeInterval : timeIntervalList) {
                        LocalTime slotTimeBegin = timeInterval.getTimeBegin();
                        LocalTime slotTimeEnd = slotTimeBegin.plusMinutes(duration);

                        while ((slotTimeBegin.isAfter(timeInterval.getTimeBegin()) && slotTimeBegin.isBefore(timeInterval.getTimeEnd()))
                                || slotTimeBegin.equals(timeInterval.getTimeBegin())
                                || (slotTimeEnd.isAfter(timeInterval.getTimeBegin()) && slotTimeEnd.isBefore(timeInterval.getTimeEnd()))
                                || slotTimeEnd.equals(timeInterval.getTimeEnd())) {
                            // while inside the interval

                            // create slot
                            Slot slot = new Slot();
                            slot.setDate(slotDate);
                            slot.setTimeBegin(slotTimeBegin);
                            slot.setTimeEnd(slotTimeEnd);
                            slot.setDoctor(doctor);

                            saveSlot(slot);

                            slotTimeBegin = slotTimeEnd;
                            slotTimeEnd = slotTimeBegin.plusMinutes(duration);

                        }
                    }
                }
            }
        }
        System.out.println("Geração de Vagas concluída");
    }

    /**
     * Recebe uma lista de dias e devolve uma lista com cores atribuídas a cada dia de acordo com
     * a disponibilidade do médico para o dia.
     */
    @Override
    public List<Day> calendarColor(List<Day> calendar, Doctor doctor) {
        LocalDate todayDate = LocalDate.now();
        ArrayList<Day> calendarColor = new ArrayList<>();

        for (Day day : calendar) {
            long totalSlots = countByDoctorAndDate(doctor, day.getDate());
            long availableSlots = countByDoctorAndIsAvailableAndDate(doctor, true, day.getDate());

            calendarColor.add(colorDay(day, todayDate, totalSlots, availableSlots));
        }
        return calendarColor;
    }

    @Override
    public List<Day> calendarColor(List<Day> calendar, String specialityName) {
        LocalDate todayDate = LocalDate.now();
        ArrayList<Day> calendarColor = new ArrayList<>();

        for (Day day : calendar) {
            long totalSlots = countByDoctorSpecialityNameAndDate(specialityName, day.getDate());
            long availableSlots = countByDoctorSpecialityNameAndIsAvailableAndDate(specialityName, true, day.getDate());
            calendarColor.add(colorDay(day, todayDate, totalSlots, availableSlots));
        }
        return calendarColor;
    }

    private Day colorDay(Day day, LocalDate todayDate, long totalSlots, long availableSlots) {
        double fraction = 1 - ((double) availableSlots) / totalSlots;

        if (totalSlots == 0 || todayDate.isAfter(day.getDate())) {
            day.setColor(CalendarColor.WHITE.getName());
        } else if (fraction >= CalendarColor.RED.getMinFraction()) {
            day.setColor(CalendarColor.RED.getName());
        } else if (fraction > CalendarColor.YELLOW.getMinFraction()) {
            day.setColor(CalendarColor.YELLOW.getName());
        } else {
            day.setColor(CalendarColor.GREEN.getName());
        }
        return day;

    }

    //TODO disponibilidade mensal <--

    public boolean hasDisponibilidadeNoMes(List<Day> calendar, Doctor doctor) {
        for (Day day : calendar) {
            long availableSlots = countByDoctorAndIsAvailableAndDate(doctor, true, day.getDate());
            if (availableSlots > 0) {
                return true;
            }
        }
        return false;
    }

}
