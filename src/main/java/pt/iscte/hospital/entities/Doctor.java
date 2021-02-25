package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


public class Doctor extends Employee {
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

    public Doctor(Long doctorId,
                  Long employeeId,
                  Long userId,
                  String name, String username, String sex, Date birthday, String address,
                  String postCode, String city, String account, String nationality, String documentType,
                  Long documentNumber, Long nif, Long patientNumber,
                  Long phone, String email, String password, String photoURL, Long licenseNumber, Set<Speciality> specialities) {
        super(employeeId, userId, name, username, sex, birthday, address,
                postCode, city, account, nationality, documentType,
                documentNumber, nif, patientNumber,
                phone, email, password, photoURL);
        this.doctorId = doctorId;
        this.licenseNumber = licenseNumber;
        this.specialities = specialities;
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
