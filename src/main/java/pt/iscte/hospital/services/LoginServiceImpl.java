package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.PatientRepository;
import pt.iscte.hospital.repositories.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validateLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (userService.validateUser(user)) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateUserNIF(String username, Long user_nif) {
        User user = userRepository.findByUsername(username);
        if (userService.validateUser(user)) {
            if (username.equals(user.getUsername()) && user_nif.equals(user.getNif())) {
                return true;
            }
        }
        return false;
    }
}
