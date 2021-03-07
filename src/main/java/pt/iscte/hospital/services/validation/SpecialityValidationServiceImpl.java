package pt.iscte.hospital.services.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.repositories.SpecialityRepository;
import pt.iscte.hospital.services.ErrorMessage;

@Service
public class SpecialityValidationServiceImpl implements SpecialityValidationService {
    // Attributes
    @Autowired
    SpecialityRepository specialityRepository;
    private Speciality speciality;
    private boolean isValid;
    private ModelMap errorModelMap;


    // Constructor
    public SpecialityValidationServiceImpl() {
        isValid = true;
        errorModelMap = new ModelMap();
    }


    // Methods
    @Override
    public SpecialityValidationService setSpeciality(Speciality speciality) {
        this.speciality = speciality;
        return this;
    }

    @Override
    public SpecialityValidationService validName() {
        Speciality specialityDB = specialityRepository.findByName(speciality.getName());

        if (specialityDB != null) {
            if (speciality.getName().equalsIgnoreCase(specialityDB.getName())) {
                isValid = false;
                errorModelMap.put("errorMsgSpeciality", ErrorMessage.SPECIALITY_NAME.getErrorMsg());
                // existe uma especialidade com o mesmo nome
            }
        }
        return this;
    }

    @Override
    public SpecialityValidationService validLength() {
        if (speciality.getName().length() < 4) {      // verificar se nome pequeno (evitar nomes curtos)
            isValid = false;
            errorModelMap.put("errorMsgSpeciality", ErrorMessage.SPECIALITY_LENGTH.getErrorMsg());
        }
        return this;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }

    @Override
    public ModelMap getErrorModelMap() {
        return errorModelMap;
    }

    @Override
    public SpecialityValidationService clear(){
        errorModelMap = new ModelMap();
        speciality = null;
        isValid = true;
        return this;
    }
}
