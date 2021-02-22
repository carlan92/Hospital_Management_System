package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import java.util.Date;


public class Doctor extends User{
    public Doctor(Long id, String username, String firstName, String lastName,
                  String sex, Date birthday, String address, String postalCode,
                  String nationality, String documentType, Long documentNumber,
                  Long nif, Long patientNumber, Long phone, String email,
                  String password, String photoURL){
        super(id, username,firstName, lastName,
                sex, birthday, address,
                postalCode, nationality, documentType,
                documentNumber, nif, patientNumber,
                phone, email, password, photoURL);
    }
}
