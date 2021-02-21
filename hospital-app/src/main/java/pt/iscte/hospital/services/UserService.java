package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.User;

public interface UserService {
    public boolean validateUser(User user);
    public void addUser(User user);
}
