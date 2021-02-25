package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="employee_type",
        discriminatorType = DiscriminatorType.STRING)
public class Employee {
    // Attributes
    @Id
    @GeneratedValue
    private Long employeeId;

    // Constructors
    public Employee() {
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
