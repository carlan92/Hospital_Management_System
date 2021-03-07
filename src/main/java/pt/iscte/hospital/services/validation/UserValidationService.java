package pt.iscte.hospital.services.validation;

import org.springframework.ui.ModelMap;
import pt.iscte.hospital.entities.User;

public interface UserValidationService {
    UserValidationService setUser(User user);

    UserValidationService validName();

    UserValidationService validPhone();

    UserValidationService validPassword();

    UserValidationService samePassword(String passwordRetyped);

    UserValidationService validPostCode();

    UserValidationService validSex();

    UserValidationService validEmail();

    UserValidationService validUsername();

    UserValidationService validDocumentType();

    UserValidationService validDocumentNumber();

    UserValidationService validPatientNumber();

    UserValidationService validNif();

    UserValidationService validEmail2();

    UserValidationService validCity();

    UserValidationService validAccount();

    UserValidationService validBirthday();

    UserValidationService validNationality();

    UserValidationService validAddress();

    UserValidationService validDocumentNumberUnique();

    UserValidationService validNifUnique ();

    UserValidationService validPatientNumberUnique();

    UserValidationService notValidPhotoUpload();

    UserValidationService notValidImageType();

    UserValidationService notValidImageSize();

    boolean isValid();

    ModelMap getErrorModelMap();
}
