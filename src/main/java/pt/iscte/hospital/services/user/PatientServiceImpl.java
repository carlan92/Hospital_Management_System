package pt.iscte.hospital.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.repositories.user.PatientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
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

    @Override
    public Patient findByUserId(Long patientId) {
        return patientRepository.findByUserId(patientId);
    }

    @Override
    public List<Patient> findAllByNameContainingIgnoreCase(String name) {
        return patientRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Patient> findAllByFirstAndLastName(String name) {
        List<Patient> patients = patientRepository.findAll();
        return filterByFirstAndLastName(name, patients);
    }

    private List<Patient> filterByFirstAndLastName(String name, List<Patient> patients) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getFirstAndLastName().toLowerCase().contains(name.toLowerCase())) {
                result.add(patient);
            }
        }
        return result;
    }
}
