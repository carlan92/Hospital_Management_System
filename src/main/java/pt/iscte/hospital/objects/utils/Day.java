package pt.iscte.hospital.objects.utils;

public class Day {
    private Integer dayId;
    private Integer dayNumber;
    private String date;

    public Day(Integer dayId, Integer dayNumber, String date) {
        this.dayId = dayId;
        this.dayNumber = dayNumber;
        this.date = date;
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
}
