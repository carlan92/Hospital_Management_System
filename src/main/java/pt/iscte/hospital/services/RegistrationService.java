package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.User;

public interface RegistrationService {
    public boolean validaNome(User user);
    public boolean validaTelefone(User user);
}

