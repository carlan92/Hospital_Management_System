package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Speciality;

public interface SpecialityService {
    void addSpeciality(Speciality speciality);

    boolean validSpeciality(Speciality speciality);

    boolean validLength(Speciality newSpeciality);
}
