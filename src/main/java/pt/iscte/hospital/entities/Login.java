package pt.iscte.hospital.entities;

public class Login {

    private static Patient connectedUser = null;

    // Methods
    public static void logout() {
        connectedUser = null;
    }

    public static Patient getConnectedUser() {
        return connectedUser;
    }

    public static void setConnectedUser(Patient connectedUser) {
        Login.connectedUser = connectedUser;
    }

    public static boolean isConnected() {
        if (connectedUser == null) {
            return false;
        }
        return true;
    }
}
