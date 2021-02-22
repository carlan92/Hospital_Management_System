package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{
    public User findByName(String name);
    public User findByEmail(String email);
    public User findByUsername(String username);

}
