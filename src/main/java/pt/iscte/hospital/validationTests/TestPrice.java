package pt.iscte.hospital.validationTests;

public class TestPrice {
    public static void main(String[] args) {
        double[] nomes = {
                9999,
                999.99,
                0,
                0.00,
                0.,
                1.,
                111.1,
                11.111,
        };

        for (double nome : nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(double nome) {
        if (nome >= 0) {
            String price = String.valueOf(nome);
            if (price.matches("\\d{1,3}(.\\d{0,2})")) {
                return true;
            }
        }
        return false;
    }
}
