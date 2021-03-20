package pt.iscte.hospital.validationTests;

public class TestEmail {
    public static void main(String[] args) {
        String[] nomes = {
                "ocram_manuel@hotmail.com",
                "@majjf.com",
                "A@b@c@example.com",
                "Abc.example.com",
                "j..s@proseware.com",
                "j.@server1.proseware.com",
                "js*@proseware.com",
                "js@proseware..com",
                "ma...ma@jjf.co",
                "ma.@jjf.com",
                "ma@@jjf.com",
                "ma@jjf.",
                "ma@jjf..com",
                "ma@jjf.c",
                "ma_@jjf",
                "ma_@jjf.",
                "ma_@jjf.com",
                "------",
                "12@hostname.com",
                "d.j@server1.proseware.com",
                "david.jones@proseware.com",
                "j.s@server1.proseware.com",
                "j@proseware.com9",
                "j_9@[129.126.118.1]",
                "jones@ms1.proseware.com",
                "js#internal@proseware.com",
                "js@proseware.com9",
                "m.a@hostname.co",
                "m_a1a@hostname.com",
                "ma.h.saraf.onemore@hostname.com.edu",
                "ma@hostname.com",
                "ma@hostname.comcom",
                "MA@hostname.coMCom",
                "ma12@hostname.com",
                "ma-a.aa@hostname.com.edu",
                "ma-a@hostname.com",
                "ma-a@hostname.com.edu",
                "ma-a@1hostname.com",
                "ma.a@1hostname.com",
                "ma@1hostname.com",
        };

        for (String nome : nomes) {
            System.out.printf("%-10s %-10s\n", nome, isValid(nome));
        }
    }

    public static boolean isValid(String nome) {
        if (nome.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,3}$")) {
            return true;
        }
        return false;
    }
}
