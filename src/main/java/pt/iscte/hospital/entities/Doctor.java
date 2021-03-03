package pt.iscte.hospital.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pt.iscte.hospital.security.Roles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "doctor_id")
public class Doctor extends Employee {
    // Attributes
    private Long licenseNumber;

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable=false)
    private Speciality speciality;

    @OneToMany(mappedBy="doctor")
    private Set<Slot> slots;


    // Constructors
    public Doctor() {
        super.setAccount("Médico");
    }

    public Doctor(Long userId,
                  String name, String username,
                  String sex, Date birthday,
                  String address, String postCode,
                  String city,
                  String nationality, String documentType,
                  Long documentNumber, Long nif,
                  Long patientNumber, Long phone,
                  String email, String password, String photoURL, Long licenseNumber, Speciality speciality) {
        super(userId, name, username, sex, birthday, address, postCode, city, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
        super.setAccount("Médico");
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
    public List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(Roles.ROLE_DOCTOR.name()));
        return roles;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                super.toString() +
                ", licenseNumber=" + licenseNumber +
                ", speciality=" + speciality +
                ", slots=" + slots +
                '}';
    }
}
