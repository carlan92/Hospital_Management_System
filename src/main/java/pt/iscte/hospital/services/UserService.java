package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.User;

public interface UserService {
    boolean validateUser(Patient user);
    boolean validateUser(String username, String password);
    void addUser(Patient user);
    Patient findUser(String username);
    User currentUser();
}
