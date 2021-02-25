package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Receptionist extends Employee {
    // Attributes
    @Id
    @GeneratedValue
    private Long idReceptionist;

    // Constructor
    public Receptionist(Long idReceptionist,
                        Long idEmployee,
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
        super(idEmployee, id, name, username, sex, birthday, address,
                postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone,
                email, password, photoURL);
        this.idReceptionist = idReceptionist;
    }

    // Methods
    public Long getIdReceptionist() {
        return idReceptionist;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "idReceptionist=" + idReceptionist +
                super.toString() +
                '}';
    }

    public void setIdReceptionist(Long idReceptionist) {
        this.idReceptionist = idReceptionist;
    }
}
