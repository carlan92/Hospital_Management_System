package pt.iscte.hospital.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.iscte.hospital.entities.User;

public interface UserService {
    boolean validateUser(User user);
    boolean validateUser(String username, String password);
    void addUser(User user);
    User findUser(String username);
    User currentUser();

    @Query("SELECT account FROM user WHERE user.username=:username")
    String findAccountByUsername(@Param("username") String username);
}
