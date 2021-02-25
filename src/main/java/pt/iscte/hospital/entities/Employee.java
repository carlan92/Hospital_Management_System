package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee extends User {
    // Attributes
    @Id
    @GeneratedValue
    private Long employeeId;

    // Constructors
    public Employee() {
    }

    public Employee(Long employeeId,
                    Long userId,
                    String name, String username, String sex, Date birthday, String address,
                    String postCode, String city, String account, String nationality, String documentType,
                    Long documentNumber, Long nif, Long patientNumber,
                    Long phone, String email, String password, String photoURL) {
        super(userId, name, username, sex, birthday, address,
                postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber,
                phone, email, password, photoURL);
    }

    // Methods
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                super.toString() +
                '}';
    }
}
