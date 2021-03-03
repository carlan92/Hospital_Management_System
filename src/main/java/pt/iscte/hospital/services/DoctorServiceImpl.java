package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.repositories.DoctorRepository;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void chamarUtente(Doctor doctor) {
        // Consultar a base de dados: por médico, por data, por checking
        //

    }

    @Override
    public void comecarConsulta() {

    }

    @Override
    public void terminarConsulta() {

    }

    @Override
    public void marcarFalta() {

    }

    @Override
    public void removerFalta() {

    }

    @Override
    public void verListaDeEspera() {

    }

    @Override
    public void desmarcarConsulta() {

    }

    @Override
    public List<Doctor> findAll(Sort sort) {
        return doctorRepository.findAll(sort);
    }
}
