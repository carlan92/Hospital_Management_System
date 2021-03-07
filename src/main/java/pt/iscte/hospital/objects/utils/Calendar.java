package pt.iscte.hospital.objects.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Calendar {


    public static List<Day> calendarList() {
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonth().getValue();
        LocalDate date = LocalDate.of(year, month, 1);

        Integer[] calendar = new Integer[42];

        int nrDays = date.lengthOfMonth();
        int weekDay = date.getDayOfWeek().getValue();

        for (int day = 1; day <= nrDays; day++) {
            calendar[day + weekDay - 2] = day;
        }

        List<Day> calendarDays = new ArrayList<>();

        for (int i = 0; i < calendar.length; i++) {
            calendarDays.add(new Day(i, calendar[i]));
        }

        return calendarDays;
    }
}
