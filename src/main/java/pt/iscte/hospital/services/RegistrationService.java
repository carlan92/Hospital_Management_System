package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.User;

public interface RegistrationService {
    public boolean validaNome(User user);

    public boolean validaTelefone(User user);

    public boolean validaPassword(User user);

    public boolean validaPostCode(User user);

    public boolean validaSexo(User user);

    public boolean validaEmail(User user);

    public boolean validaUsername(User user);
}

