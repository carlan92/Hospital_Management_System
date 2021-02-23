package pt.iscte.hospital.services;

public interface LoginService {
    boolean validateLogin(String username, String password);
    boolean validateUserNIF(String username, Long user_nif);
}
