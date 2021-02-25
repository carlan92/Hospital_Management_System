package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Employee extends User{
    // Attributes
    @Id
    @GeneratedValue
    private Long idEmployee;
    @OneToMany
    private List<Speciality> specialities ;

    // Constructor
    public Employee(Long idEmployee,
                    Long id,
                    String name, String username, String sex, Date birthday, String address,
                    String postCode, String city, String account, String nationality, String documentType,
                    Long documentNumber, Long nif, Long patientNumber,
                    Long phone, String email, String password, String photoURL) {
        super(id, name, username, sex, birthday, address,
                postCode, city, account, nationality, documentType,
                documentNumber, nif,  patientNumber,
                phone, email, password, photoURL);
    }

    // Methods
    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                super.toString() +
                '}';
    }
}
