package pt.iscte.hospital.objects.utils;

public enum Month {
    JANUARY(1, "Janeiro"), FEBRUARY(2, "Fevereiro"), MARCH(3, "Março"), APRIL(4, "Abril"), MAY(5, "Maio"), JUNE(6, "Junho"), JULY(7, "Julho"), AUGUST(8, "Agosto"), SEPTEMBER(9, "Setembro"), OCTOBER(10, "Outubro"),  NOVEMBER(11, "Novembro"), DECEMBER(12, "Dezembro");

    // Attributes
    private final int monthNumber;
    private String description;

    // Constructor
    Month (int monthNumber, String description) {
        this.monthNumber =monthNumber;
        this.description = description;
    }

    // Methods
    public int getMonthNumber() {
        return monthNumber;
    }

    public String getDescription() {
        return description;
    }
}





