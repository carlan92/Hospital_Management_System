package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.repositories.PatientRepository;

import java.util.List;

public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public List<Patient> findAll(Sort sort) {
        return patientRepository.findAll(sort);
    }
}
