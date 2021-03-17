package pt.iscte.hospital.objects.utils;

import java.time.LocalDate;

public class Day {
    private final Integer dayId;
    private final Integer dayNumber;
    private final String dateStr;
    private final LocalDate date;
    private String color;

    public Day(Integer dayId, Integer dayNumber, String dateStr, LocalDate date) {
        this.dayId = dayId;
        this.dayNumber = dayNumber;
        this.dateStr = dateStr;
        this.date = date;
        this.color = CalendarColor.WHITE.getName();
    }

    public Integer getDayId() {
        return dayId;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public String getDateStr() {
        return dateStr;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
