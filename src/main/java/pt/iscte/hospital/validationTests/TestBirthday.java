package pt.iscte.hospital.validationTests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBirthday {
    public static void main(String[] args) {
        Date[] nomes = {
                new Date("2010/01/01"),
                new Date("1982/02/10"),
                new Date("1000/2/2"),

        };

        for (Date nome : nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(Date nome) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date= simpleDateFormat.format(nome);
        System.out.println(date);
        if(date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
            return true;
        }
        return false;
    }
}
