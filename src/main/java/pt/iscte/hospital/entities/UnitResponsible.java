package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UnitResponsible extends Employee {
    // Attributes
    @Id
    @GeneratedValue
    private Long idUnitResponsible;

    // Constructor
    public UnitResponsible(Long idUnitResponsible,
                           Long idEmployee,
                           Long id,
                           String name,
                           String username,
                           String sex,
                           Date birthday,
                           String address,
                           String postCode,
                           String city, String account, String nationality, String documentType,
                           Long documentNumber, Long nif, Long patientNumber, Long phone,
                           String email, String password, String photoURL) {
        super(idEmployee, id, name, username, sex, birthday, address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone,
                email, password, photoURL);
        this.idUnitResponsible = idUnitResponsible;
    }


    // Methods
    public Long getIdUnitResponsible() {
        return idUnitResponsible;
    }

    public void setIdUnitResponsible(Long idUnitResponsible) {
        this.idUnitResponsible = idUnitResponsible;
    }

    @Override
    public String toString() {
        return "UnitResponsible{" +
                "idUnitResponsible=" + idUnitResponsible +
                super.toString() +
                '}';
    }
}
