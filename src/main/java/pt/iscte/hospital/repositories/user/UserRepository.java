package pt.iscte.hospital.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    //User findByName(String name);
    User findByUserId(Long userId);

    User findByNif(Long nif);
    User findByDocumentNumber(Long documentNumber);
    User findByPatientNumber(Long patientNumber);

    User findByNifAndAccount(Long nif, String account);
    User findByDocumentNumberAndAccount(Long documentNumber, String account);
    User findByPatientNumberAndAccount(Long patientNumber, String account);
}
