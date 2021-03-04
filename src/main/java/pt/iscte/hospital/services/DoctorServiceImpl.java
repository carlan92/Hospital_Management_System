package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.repositories.DoctorRepository;
import pt.iscte.hospital.repositories.SpecialityRepository;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    //Methods
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

    @Override
    public List<Doctor> findAllBySpeciality(String specialityName){
        Speciality speciality = specialityRepository.findByName(specialityName);
        return doctorRepository.findAllBySpeciality(speciality);
    }

    @Override
    public List<Doctor> findAllByNameContainingIgnoreCase(String name) {
        return doctorRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Doctor> findAllByNameContainingIgnoreCaseAndSpeciality(String name, String specialityName) {
        Speciality speciality = specialityRepository.findByName(specialityName);
        return doctorRepository.findAllByNameContainingIgnoreCaseAndSpeciality(name, speciality);
    }
}
