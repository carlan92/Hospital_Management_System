package pt.iscte.hospital.entities;

public class Login {

    private static User connectedUser = null;

    // Methods
    public static void logout() {
        connectedUser = null;
    }

    public static User getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(User connectedUser) {
        Login.connectedUser = connectedUser;
    }

    public static boolean isConnected() {
        if (connectedUser == null) {
            return false;
        }
        return true;
    }
}
