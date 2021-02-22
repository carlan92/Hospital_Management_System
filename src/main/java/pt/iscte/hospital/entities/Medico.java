package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import java.util.Date;


public class Medico extends User{
    public Medico(Long id, String firstName, String lastName, String sex, Date birthday, String address, String postalCode, String nationality, String documentType, Long documentNumber, Long nif, Long utenteNumber, Long telemovel, String email, String password) {
        super(id, firstName, lastName, sex, birthday, address, postalCode, nationality, documentType, documentNumber, nif, utenteNumber, telemovel, email, password);
    }
}
