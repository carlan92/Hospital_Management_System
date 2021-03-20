package pt.iscte.hospital.validationTests;

public class TestPassword {
    public static void main(String[] args) {
        String[] nomes = {
                "1",
                "261316657L",
                "985675121L",
                "21121L",
                "91111111L",
                "125",
                "123456789123456",
                "1234567891234567",
        };

        for (String nome: nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome){
           if(nome.matches(".{4,15}")){
               return true;
           }
           return false;
    }
}
