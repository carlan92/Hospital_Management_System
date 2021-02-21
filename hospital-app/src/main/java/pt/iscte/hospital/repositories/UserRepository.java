package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{
    public User findByFirstName(String firstName);
    public User findByEmail(String email);

}
