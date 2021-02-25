package pt.iscte.hospital.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DiscriminatorValue("UnitResponsible")
public class UnitResponsible extends Employee {
    // Attributes


    // Constructors
    public UnitResponsible() {
    }



    // Methods


}
