package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Speciality {
    // Attributes
    @Id
    @GeneratedValue
    private Long idSpeciality;
    @OneToMany
    private List<Doctor> doctors;

    // Constructor
    public Speciality(Long idSpeciality, List<Doctor> doctors) {
        this.idSpeciality = idSpeciality;
        this.doctors = doctors;
    }

    // Methods
    public Long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Long idSpeciality) {
        this.idSpeciality = idSpeciality;
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
                "idSpeciality=" + idSpeciality +
                ", doctors=" + doctors +
                '}';
    }
}
