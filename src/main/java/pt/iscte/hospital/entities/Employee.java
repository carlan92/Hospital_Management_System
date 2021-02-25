package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Employee")
public class Employee extends User {
    // Attributes


    // Constructors
    public Employee() {
    }

    public Employee(Long userId,
                   String name, String username,
                   String sex, Date birthday,
                   String address, String postCode,
                   String city, String account,
                   String nationality, String documentType,
                   Long documentNumber, Long nif,
                   Long patientNumber, Long phone,
                   String email, String password, String photoURL) {
        super(userId, name, username, sex, birthday, address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
    }

    // Methods


    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                '}';
    }
}
