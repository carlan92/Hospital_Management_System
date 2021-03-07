package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.User;

public interface RegistrationService {
    boolean validName(User user);

    boolean validPhone(User user);

    boolean validPassword(User user);

    boolean validPostCode(User user);

    boolean validSex(User user);

    boolean validEmail(User user);

    boolean validUsername(User user);

    boolean validDocumentType(User user);

    boolean validDocumentNumber(User user);

    boolean validPatientNumber(User user);

    boolean validNif(User user);

    boolean validEmail2(User user);

    boolean validCity(User user);

    boolean validAccount(User user);

    boolean validBirthday(User user);

    boolean validNationality(User user);

    boolean validAddress(User user);

    boolean validDocumentNumberUnique(User user);

    boolean validNifUnique (User user);

    boolean validPatientNumberUnique(User user);

    void encryptPassword(User user);

    void changeEncryptPassword(User user, String password);
}

