package pt.iscte.hospital.services;

import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll(Sort sort);

    Patient findByUsername(String username);
}
