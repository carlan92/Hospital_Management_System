package pt.iscte.hospital.entities;

public class Login {

    private static User connectedUser=null;

    public static User getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(User connectedUser) {
        Login.connectedUser = connectedUser;
    }
}
