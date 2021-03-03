package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.repositories.PatientRepository;
import pt.iscte.hospital.repositories.UserRepository;
import pt.iscte.hospital.security.IAuthenticationFacade;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(Patient user) {
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User currentUser(){
        String username = authenticationFacade.getAuthentication().getName();
        // procurar na base de dados
        User user = userRepository.findByUsername(username);


        return user;
    }

    @Override
    public boolean validateUser(String username, String password) {
        System.out.println("Verificar pass: " + password); // TODO verificar se a pass está encriptada
        User userLogged = patientRepository.findByUsername(username);
        if (userLogged != null){
            //ver password
            if (userLogged.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(Patient user) {
        patientRepository.save(user);
    }

    @Override
    public Patient findUser(String username) {
        return patientRepository.findByUsername(username);
    }
}
