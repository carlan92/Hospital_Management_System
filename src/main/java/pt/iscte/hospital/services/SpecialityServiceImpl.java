package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.repositories.SpecialityRepository;

import java.util.Locale;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public void addSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }

    @Override
    public boolean validSpeciality(Speciality newSpeciality) {
        Speciality specialityDB = specialityRepository.findByName(newSpeciality.getName());

        if (specialityDB != null) {
            if (newSpeciality.getName().equalsIgnoreCase(specialityDB.getName())) {
                return false;   // existe uma especialidade com o mesmo nome
            } else {
                return true;    // não foi encontrada especialidade com o mesmo nome
            }
        } else {
            return true;
        }
    }

    @Override
    public boolean validLength(Speciality newSpeciality){
        return (newSpeciality.getName().length() > 3);      // verificar se nome pequeno (evitar nomes curtos)
    }

}
