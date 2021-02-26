package pt.iscte.hospital;

public class TestName {
    public static void main(String[] args) {
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

        for (String nome: nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome){
        return nome.matches("[A-Za-zÀ-ÿ']{2,}||[e]{1}");
    }
}

