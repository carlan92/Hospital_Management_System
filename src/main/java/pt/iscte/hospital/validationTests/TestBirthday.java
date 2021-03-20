package pt.iscte.hospital.validationTests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class TestBirthday {
    public static void main(String[] args) {
        String[] nomes = {
                "31/05/2017",   //valido
                "29/02/2016",   //ano bissexto, valido
                "29/02/2017",  //nao existe, invalido
                "31/04/2017", //so tem 30 dias, invalido
                "2/2/2000",  //falta digitos, invalido
                "02/02/1200", //nao ha ninguem tao velho, invalido
                "02/02/2290" //nao é possivel é futuro, invalido
        };

        for (String nome : nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome) {
        String pattern = "dd/MM/uuuu";
        DateTimeFormatter df = DateTimeFormatter
                .ofPattern(pattern)
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(nome, df);
            if(date.isAfter(LocalDate.now())|| date.isBefore(LocalDate.of(1900,1,1))){
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
