package pt.iscte.hospital.validationTests;

public class TestPostCode {
    public static void main(String[] args) {
        String[] nomes = {
                "1234-567",
                "123-123",
                "a456-a45",
                "1451-1451",
                "1589-000",
                "",
                " "
        };

        for (String nome: nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome){
           if(nome.matches("[0-9]{4}[-][0-9]{3}")||nome.matches("")){
               return true;
           }
           return false;
    }
}
