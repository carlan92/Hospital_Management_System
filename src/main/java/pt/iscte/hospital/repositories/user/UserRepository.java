package pt.iscte.hospital.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);

    User findByName(String name);
    User findByNif(Long nif);
    User findByDocumentNumber(Long documentNumber);
    User findByPatientNumber(Long patientNumber);
}
