package pt.iscte.hospital.validationTests;

public class TestSexo {
    public static void main(String[] args) {
        String[] nomes = {
                "Masculino",
                "Feminino",
                "Fem",
                "Masculin",
        };

        for (String nome: nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome){
           if(nome.matches("Feminino")||nome.matches("Masculino")){
               return true;
           }
           return false;
    }
}
