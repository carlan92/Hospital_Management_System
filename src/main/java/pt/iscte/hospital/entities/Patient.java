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
    private Long idPatient;

    public Patient(Long idPatient,
                   Long id,
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
        super(id, name, username, sex, birthday,
                address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber,
                phone, email, password, photoURL);
        this.idPatient = idPatient;
    }

    // Methods
    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                super.toString() +
                '}';
    }
}

