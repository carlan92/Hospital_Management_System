package pt.iscte.hospital.validationTests;

public class TestMorada {
    public static void main(String[] args) {
        String[] nomes = {
                "Rua Dr. Francisco Quaresma de Almeida, nº1 - 2ºDro",
                "Rua das Flores",
                "Praia d'el Rey",
                "Canto & Castro",
                "% /addjaljldjaljw",
                "aaaaa",
                " ",
                "    ",
                "-----------",
                "Praia das Maças_(#lote1).",
        };

        for (String nome : nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome) {
        String[] palavras = nome.split(" ");
        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i].matches("[A-Za-zÀ-ÿ'/-]{1,}")) {
                return true;
            }
        }
        return false;
    }
}

