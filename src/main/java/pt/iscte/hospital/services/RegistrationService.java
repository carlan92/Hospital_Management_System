package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.User;

public interface RegistrationService {
    public boolean validName(User user);

    public boolean validPhone(User user);

    public boolean validPassword(User user);

    public boolean validPostCode(User user);

    public boolean validSex(User user);

    public boolean validEmail(User user);

    public boolean validUsername(User user);

    public boolean validDocumentType(User user);

    public boolean validDocumentNumber(User user);

    public boolean validPatientNumber(User user);

    public boolean validNif(User user);

    public boolean validEmail2(User user);

    public boolean validCity(User user);

    public boolean validAccount(User user);

    public boolean validBirthday(User user);

    public boolean validNationality(User user);

    public boolean validAddress(User user);

    public boolean validDocumentNumberUnique(User user);

    public boolean validNifUnique (User user);

    public boolean validPatientNumberUnique(User user);
}

