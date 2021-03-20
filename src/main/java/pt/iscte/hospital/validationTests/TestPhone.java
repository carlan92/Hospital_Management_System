package pt.iscte.hospital.validationTests;

public class TestPhone {
    public static void main(String[] args) {
        Long[] nomes = {
                916116538L,
                261316657L,
                985675121L,
                21121L,
                91111111L,
        };

        for (Long nome: nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(Long nome){
        String phone=String.valueOf(nome);
           if(phone.matches("^9[1236][0-9]{7}$|^2[3-9][1-9][0-9]{6}$|^2[12][0-9]{7}$")){
               return true;
           }
           return false;
    }
}
