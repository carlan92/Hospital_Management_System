package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("Doctor")
public class Doctor extends Employee {
    // Attributes
    private Long licenseNumber;

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable=false)    //https://www.baeldung.com/jpa-many-to-many
    private Speciality speciality;

    @OneToMany(mappedBy="doctor")
    private Set<Slot> slots;

    // Constructors
    public Doctor() {
    }

    public Doctor(Long userId,
                  String name, String username,
                  String sex, Date birthday,
                  String address, String postCode,
                  String city, String account,
                  String nationality, String documentType,
                  Long documentNumber, Long nif,
                  Long patientNumber, Long phone,
                  String email, String password, String photoURL, Long licenseNumber, Speciality speciality) {
        super(userId, name, username, sex, birthday, address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
        this.licenseNumber = licenseNumber;
        this.speciality = speciality;
    }

    // Methods
    public Long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Speciality getSpecialities() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                ", licenseNumber=" + licenseNumber +
                super.toString() +
                '}';
    }
}
