package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Speciality;

public interface SpecialityService {
    void addSpeciality(Speciality speciality);

    public boolean validSpeciality(Speciality speciality);
}
