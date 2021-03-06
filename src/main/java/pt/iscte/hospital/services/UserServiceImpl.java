package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.*;
import pt.iscte.hospital.repositories.UserRepository;
import pt.iscte.hospital.security.IAuthenticationFacade;
import pt.iscte.hospital.security.Role;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

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
    public User currentUser() {
        String username = authenticationFacade.getAuthentication().getName();
        User user = userRepository.findByUsername(username);


        return user;
    }

    @Override
    public boolean validateUser(String username, String password) {
        System.out.println("Verificar pass: " + password); // TODO verificar se a pass está encriptada
        User userLogged = userRepository.findByUsername(username);
        if (userLogged != null) {
            //ver password
            if (userLogged.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<GrantedAuthority> getAuthorities(String username) {
        User user = userRepository.findByUsername(username);

        return user.getAuthorities();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role getUserRole(User user) {
        Role role = Enum.valueOf(Role.class, user.getAuthorities().get(0).getAuthority());
        return role;
    }

    @Override
    public String getUserMainPage(User user) {
        if (user == null) {
            return "public/main";
        }
        Role role = getUserRole(user);
        return role.getMainPage();
    }

    @Override
    public boolean validateUserNIF(String username, Long user_nif) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if (username.equals(user.getUsername()) && user_nif.equals(user.getNif())) {
                return true;
            }
        }
        return false;
    }
}


