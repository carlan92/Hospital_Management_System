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

    @ManyToMany     //https://www.baeldung.com/jpa-many-to-many
    @JoinTable(
            name = "doctor_has_speciality",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities;

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
                  String email, String password, String photoURL, Long licenseNumber, Set<Speciality> specialities) {
        super(userId, name, username, sex, birthday, address, postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
        this.licenseNumber = licenseNumber;
        this.specialities = specialities;
    }

    // Methods
    public Long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(Long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                ", licenseNumber=" + licenseNumber +
                super.toString() +
                '}';
    }
}
