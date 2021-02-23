package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import java.util.Date;


public class Patient extends User{
    public Patient(Long id, String name, String username, String sex, Date birthday, String address, String postCode, String city, String account, String nationality, String documentType, Long documentNumber, Long nif, Long patientNumber, Long phone, String email, String password, String photoURL) {
        super(id, name, username, sex, birthday, address, postCode, city, account, nationality, documentType, documentNumber, nif, patientNumber, phone, email, password, photoURL);
    }
}

