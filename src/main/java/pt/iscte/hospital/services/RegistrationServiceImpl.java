package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.NationalityRepository;
import pt.iscte.hospital.repositories.UserRepository;

import java.text.SimpleDateFormat;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    public void encryptPassword(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
    }
    public void changeEncryptPassword(User user, String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
    }


}

