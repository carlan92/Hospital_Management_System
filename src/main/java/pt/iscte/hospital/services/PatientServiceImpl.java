package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.repositories.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll(Sort sort) {
        return patientRepository.findAll(sort);
    }

    @Override
    public Patient findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }
}
