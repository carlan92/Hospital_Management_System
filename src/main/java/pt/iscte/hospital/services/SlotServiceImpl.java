package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Slot;
import pt.iscte.hospital.objects.utils.TimeInterval;
import pt.iscte.hospital.repositories.DoctorRepository;
import pt.iscte.hospital.repositories.SlotRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<Slot> findAllByDoctorAndDateOrderByTimeBeginAsc(Doctor doctor, Date date) {
        return slotRepository.findAllByDoctorAndDateOrderByTimeBeginAsc(doctor, date);
    }

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
            System.out.println("day:" + day);

            // if the week day is available
            if (weekDaysList.contains(dayOfWeek)) { // TODO
                // for each doctor
                for (Doctor doctor : doctors) {
                    System.out.println("\tdoctor:" + doctor.getFirstAndLastName());
                    for (Object timeInterval : timeIntervalList) {
                        // if inside the interval
                        if(true){
                            // create slot
                            Slot slot = new Slot();
                            slot.setDate(slotDate);
                        }
                    }
                }
            }
        }

    }
}
