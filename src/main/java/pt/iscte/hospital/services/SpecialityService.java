package pt.iscte.hospital.services;

import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Speciality;

import java.util.List;

public interface SpecialityService {
    void addSpeciality(Speciality speciality);

    boolean validSpeciality(Speciality speciality);

    boolean validLength(Speciality newSpeciality);

    List<Speciality> findAll(Sort sort);
}
