package pt.iscte.hospital.validationTests;

public class TestCity {
    public static void main(String[] args) {
        String[] nomes = {
                "Torres Vedras",
                "Torres-Vedras",
                "------",
                "Lisboa",
                "Louça",
                " ",
                "Águeda",
                "amarante",
                "Montemor o Velho",
                "'"
        };

        for (String nome : nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome) {
        if (nome.matches("^[A-Za-zÀ-ÿ'][a-zA-ZÀ-ÿ'\\s-]+[a-zA-ZÀ-ÿ']$")) {
            return true;
        }
        return false;
    }
}
