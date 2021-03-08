package pt.iscte.hospital.objects.utils;

import java.time.LocalDate;

public class Day {
    private Integer dayId;
    private Integer dayNumber;
    private String date;
    private LocalDate date1;
    private String color;

    public Day(Integer dayId, Integer dayNumber, String date, LocalDate date1) {
        this.dayId = dayId;
        this.dayNumber = dayNumber;
        this.date = date;
        this.date1 = date1;
        this.color = "white";
    }

    public Integer getDayId() {
        return dayId;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public String getDate() {
        return date;
    }

    public LocalDate getDate1() {
        return date1;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
