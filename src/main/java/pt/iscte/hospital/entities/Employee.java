package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends User {
    // Attributes


    // Constructors
    public Employee() {
        super.setAccount("Funcionário");
    }

    public Employee(Long userId,
                   String name, String username,
                   String sex, Date birthday,
                   String address, String postCode,
                   String city,
                   String nationality, String documentType,
                   Long documentNumber, Long nif,
                   Long patientNumber, Long phone,
                   String email, String password, String photoURL) {
        super(userId, name, username, sex, birthday, address, postCode, city, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
        super.setAccount("Funcionário");
    }

    // Methods


    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                '}';
    }
}
