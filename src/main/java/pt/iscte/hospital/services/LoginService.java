package pt.iscte.hospital.services;

public interface LoginService {
    boolean validateLogin(String username, String password);
}
