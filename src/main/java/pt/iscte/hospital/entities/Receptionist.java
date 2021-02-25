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
    private Long receptionistId;

    // Constructors
    public Receptionist() {
    }

    public Receptionist(Long receptionistId,
                        Long employeeId,
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
        super(employeeId, userId, name, username, sex, birthday, address,
                postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone,
                email, password, photoURL);
        this.receptionistId = receptionistId;
    }

    // Methods
    public Long getReceptionistId() {
        return receptionistId;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "receptionistId=" + receptionistId +
                super.toString() +
                '}';
    }

    public void setReceptionistId(Long receptionistId) {
        this.receptionistId = receptionistId;
    }
}
