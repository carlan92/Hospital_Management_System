package pt.iscte.hospital.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Speciality {
    // Attributes
    @Id
    @GeneratedValue
    private Long specialityId;

    private String name;

    @ManyToMany(mappedBy = "specialities")
    private List<Doctor> doctors;


    // Constructors
    public Speciality() {
    }

    public Speciality(Long specialityId, List<Doctor> doctors) {
        this.specialityId = specialityId;
        this.doctors = doctors;
    }

    // Methods
    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "specialityId=" + specialityId +
                ", name='" + name + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
