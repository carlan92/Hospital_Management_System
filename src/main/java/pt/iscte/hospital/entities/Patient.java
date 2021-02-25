package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Patient extends User {
    // Attributes


    // Constructors
    public Patient() {
    }

    public Patient(Long userId,
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

