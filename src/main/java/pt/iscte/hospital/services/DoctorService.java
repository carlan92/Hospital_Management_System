package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Doctor;

public interface DoctorService {
    void chamarUtente(Doctor doctor);
    void comecarConsulta();
    void terminarConsulta();
    void marcarFalta();
    void removerFalta();
    void verListaDeEspera();
    void desmarcarConsulta();

}
