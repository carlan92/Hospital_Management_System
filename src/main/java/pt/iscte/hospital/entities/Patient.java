package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "patient_id")
public class Patient extends User {
    // Attributes
    @OneToMany(mappedBy="patient")
    private Set<Appointment> appointments;


    // Constructors
    public Patient() {
        super.setAccount("Utente");
    }

    public Patient(Long userId,
                   String name, String username,
                   String sex, Date birthday,
                   String address, String postCode,
                   String city,
                   String nationality, String documentType,
                   Long documentNumber, Long nif,
                   Long patientNumber, Long phone,
                   String email, String password, String photoURL) {
        super(userId, name, username, sex, birthday, address, postCode, city, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
        super.setAccount("Utente");
    }

    // Methods

}

