package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


public class Receptionist extends Employee {
    // Attributes
    @Id
    @GeneratedValue
    private Long receptionistId;

    // Constructors
    public Receptionist() {
    }



    // Methods
    public Long getReceptionistId() {
        return receptionistId;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "receptionistId=" + receptionistId +
                super.toString() +
                '}';
    }

    public void setReceptionistId(Long receptionistId) {
        this.receptionistId = receptionistId;
    }
}
