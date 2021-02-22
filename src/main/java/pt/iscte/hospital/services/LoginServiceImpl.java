package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Override
    public boolean validateLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (!userService.validateUser(user)) {
            return false;
        } else if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}
