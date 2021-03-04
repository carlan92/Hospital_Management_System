package pt.iscte.hospital.services;

import org.springframework.security.core.GrantedAuthority;
import pt.iscte.hospital.entities.User;

import java.util.List;

public interface UserService {
    boolean validateUser(User user);

    boolean validateUser(String username, String password);

    void addUser(User user);

    User findByUsername(String username);

    User findUser(String username);

    User currentUser();

    List<GrantedAuthority> getAuthorities(String username);
}
