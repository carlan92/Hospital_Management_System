package pt.iscte.hospital.objects.utils;

public enum CalendarColor {
    WHITE("white",0),
    GREEN("green",0),
    RED("red", 1),
    YELLOW("yellow", 0.5);

    private String name;
    private double minFraction;

    CalendarColor(String name, double minFraction) {
        this.name = name;
        this.minFraction = minFraction;
    }

    public String getName() {
        return name;
    }

    public double getMinFraction() {
        return minFraction;
    }
}
