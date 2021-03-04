package pt.iscte.hospital.services;

import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;

import java.util.List;

public interface DoctorService {
    void chamarUtente(Doctor doctor);
    void comecarConsulta();
    void terminarConsulta();
    void marcarFalta();
    void removerFalta();
    void verListaDeEspera();
    void desmarcarConsulta();
    List<Doctor> findAll(Sort sort);
    List<Doctor> findAllBySpeciality(String specialityName);

}
