package pt.iscte.hospital.services.validation;

import org.springframework.ui.ModelMap;
import pt.iscte.hospital.entities.Speciality;

public interface SpecialityValidationService {
    SpecialityValidationService setSpeciality(Speciality speciality);
    SpecialityValidationService validName();
    SpecialityValidationService validLength();
    SpecialityValidationService validPrice();
    boolean isValid();
    ModelMap getErrorModelMap();
    SpecialityValidationService clear();
}
