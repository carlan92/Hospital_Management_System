package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("Receptionist")
public class Receptionist extends Employee {
    // Attributes
    @OneToOne(mappedBy = "receptionist")
    private Invoice invoice;

    // Constructors
    public Receptionist() {
    }

    public Receptionist(Long userId,
                   String name, String username,
                   String sex, Date birthday,
                   String address, String postCode,
                   String city, String account,
                   String nationality, String documentType,
                   Long documentNumber, Long nif,
                   Long patientNumber, Long phone,
                   String email, String password, String photoURL) {
        super(userId, name, username, sex, birthday, address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
    }

    // Methods

}
