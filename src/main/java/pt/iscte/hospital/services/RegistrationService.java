package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.User;

public interface RegistrationService {
    void encryptPassword(User user);

    void changeEncryptPassword(User user, String password);
}

