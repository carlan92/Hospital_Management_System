package pt.iscte.hospital.objects.utils;

public class Day {
    private Integer dayId;
    private Integer dayNumber;

    public Day(Integer dayId, Integer dayNumber) {
        this.dayId = dayId;
        this.dayNumber = dayNumber;
    }

    public Integer getDayId() {
        return dayId;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }
}
