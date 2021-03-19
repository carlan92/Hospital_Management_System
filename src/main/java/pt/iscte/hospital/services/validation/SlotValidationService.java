package pt.iscte.hospital.services.validation;

import org.springframework.ui.ModelMap;
import pt.iscte.hospital.entities.Slot;

public interface SlotValidationService {
    SlotValidationService setSlot(Slot slot);
    SlotValidationService validSlot();
    boolean isValid();
    ModelMap getErrorModelMap();
    SlotValidationService clear();
}
