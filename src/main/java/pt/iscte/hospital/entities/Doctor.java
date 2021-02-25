package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Doctor extends Employee {
    // Attributes
    @Id
    @GeneratedValue
    private Long idDoctor;
    private Long licenseNumber;

    // Constructor
    public Doctor(Long idDoctor,
                  Long idEmployee,
                  Long id,
                  String name, String username, String sex, Date birthday, String address,
                  String postCode, String city, String account, String nationality, String documentType,
                  Long documentNumber, Long nif, Long patientNumber,
                  Long phone, String email, String password, String photoURL, Long licenseNumber) {
        super(idEmployee, id, name, username, sex, birthday, address,
                postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber,
                phone, email, password, photoURL);
        this.idDoctor = idDoctor;
        this.licenseNumber = licenseNumber;
    }

    // Methods
    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", licenseNumber=" + licenseNumber +
                super.toString() +
                '}';
    }
}
