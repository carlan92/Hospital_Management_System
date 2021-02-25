package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Patient extends User {
    // Attributes
    @Id
    @GeneratedValue
    private Long patientId;

    // Constructors
    public Patient() {
    }

    public Patient(Long patientId,
                   Long userId,
                   String name,
                   String username,
                   String sex,
                   Date birthday,
                   String address,
                   String postCode,
                   String city,
                   String account,
                   String nationality,
                   String documentType,
                   Long documentNumber,
                   Long nif,
                   Long patientNumber,
                   Long phone,
                   String email,
                   String password,
                   String photoURL) {
        super(userId, name, username, sex, birthday,
                address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber,
                phone, email, password, photoURL);
        this.patientId = patientId;
    }

    // Methods
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                super.toString() +
                '}';
    }
}

