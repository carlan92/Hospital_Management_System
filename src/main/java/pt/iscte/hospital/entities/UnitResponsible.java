package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "unit_responsible_id")
// Same as user_id | Hibernate Inheritance Mapping: Joined Table
public class UnitResponsible extends Employee {
    // Attributes

    // Constructors
    public UnitResponsible() {
    }

    public UnitResponsible(String name, String username,
                           String sex, Date birthday,
                           String address, String postCode,
                           String city, String account,
                           String nationality, String documentType,
                           Long documentNumber, Long nif,
                           Long patientNumber, Long phone,
                           String email, String password, String photoURL) {
        super(name, username, sex, birthday, address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
    }

    // Methods

}
