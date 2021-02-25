package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


public class UnitResponsible extends Employee {
    // Attributes
    @Id
    @GeneratedValue
    private Long unitResponsibleId;

    // Constructors
    public UnitResponsible() {
    }

    public UnitResponsible(Long unitResponsibleId,
                           Long employeeId,
                           Long userId,
                           String name,
                           String username,
                           String sex,
                           Date birthday,
                           String address,
                           String postCode,
                           String city, String account, String nationality, String documentType,
                           Long documentNumber, Long nif, Long patientNumber, Long phone,
                           String email, String password, String photoURL) {
        super(employeeId, userId, name, username, sex, birthday, address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone,
                email, password, photoURL);
        this.unitResponsibleId = unitResponsibleId;
    }


    // Methods
    public Long getUnitResponsibleId() {
        return unitResponsibleId;
    }

    public void setUnitResponsibleId(Long unitResponsibleId) {
        this.unitResponsibleId = unitResponsibleId;
    }

    @Override
    public String toString() {
        return "UnitResponsible{" +
                "unitResponsibleId=" + unitResponsibleId +
                super.toString() +
                '}';
    }
}
