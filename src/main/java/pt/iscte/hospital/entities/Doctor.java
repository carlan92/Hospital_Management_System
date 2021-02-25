package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Doctor {
    // Attributes
    @Id
    @GeneratedValue
    private Long doctorId;
    private Long licenseNumber;

    @ManyToMany     //https://www.baeldung.com/jpa-many-to-many
    @JoinTable(
            name = "doctor_has_speciality",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities;

    // Constructors
    public Doctor() {
    }


    // Methods
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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
                "doctorId=" + doctorId +
                ", licenseNumber=" + licenseNumber +
                super.toString() +
                '}';
    }
}
