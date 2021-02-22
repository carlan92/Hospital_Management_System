package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(User user) {
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
