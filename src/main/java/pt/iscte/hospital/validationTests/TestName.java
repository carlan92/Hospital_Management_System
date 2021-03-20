package pt.iscte.hospital.validationTests;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestName {


    public static void main(String[] args) {
        System.out.println(DayOfWeek.FRIDAY.getValue());
        LocalDate date1 = LocalDate.of(2021, 3, 5);
        System.out.println(date1.getDayOfWeek().getValue());

        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonth().getValue();
        System.out.println("month: " + month);
        LocalDate date = LocalDate.of(year, month, 1);
        int[] calendar = new int[42];
        int nrDays = date.lengthOfMonth();
        int weekDay = DayOfWeek.FRIDAY.getValue();
        for (int day = 1; day <= nrDays; day++) {
            calendar[day + weekDay - 2] = day;
        }

        for (int day : calendar) {
            System.out.println(day);
        }

        testName();

    }

    public static void testName() {
        String[] nomes = {
                "Pedro",
                "pedro",
                "ç",
                "J@",
                "Mª",
                "M-a",
                "João",
                "Mário",
                "%",
                "'",
                "e",
                "o'neil",
                "de",
                "d.",
                "Maça",
        };

        for (String nome : nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome) {
        return nome.matches("[A-Za-zÀ-ÿ']{2,}||[e]{1}");
    }
}

