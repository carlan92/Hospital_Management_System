package pt.iscte.hospital.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ControlCreationSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate date;
    private boolean wasGenerated;

    public ControlCreationSlot() {
        this.wasGenerated = false;
    }

}
