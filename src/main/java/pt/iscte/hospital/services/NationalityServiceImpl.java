package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.repositories.NationalityRepository;

import java.util.List;

public class NationalityServiceImpl implements NationalityService {
    @Autowired
    NationalityRepository nationalityRepository;

    @Override
    public List<Nationality> findAll() {
        return nationalityRepository.findAll();
    }
}
