package pt.iscte.hospital.entities;

public class LogIn {

    private static User connectedUser=null;

    public static User getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(User connectedUser) {
        LogIn.connectedUser = connectedUser;
    }
}
