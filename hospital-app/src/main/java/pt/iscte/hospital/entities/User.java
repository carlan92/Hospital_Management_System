package pt.iscte.hospital.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String sex;
    private Date birthday;
    private String address;
    private String postalCode;
    private String nationality;
    private String documentType;
    private Long documentNumber;
    private Long nif;
    private Long utenteNumber;
    private Long telemovel;
    private String email;
    private String password;

    public User (){

    }
    public User(Long id, String firstName, String lastName, String sex, Date birthday, String address, String postalCode, String nationality, String documentType, Long documentNumber, Long nif, Long utenteNumber, Long telemovel, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.postalCode = postalCode;
        this.nationality = nationality;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.nif = nif;
        this.utenteNumber = utenteNumber;
        this.telemovel = telemovel;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
        this.nif = nif;
    }

    public Long getUtenteNumber() {
        return utenteNumber;
    }

    public void setUtenteNumber(Long utenteNumber) {
        this.utenteNumber = utenteNumber;
    }

    public Long getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(Long telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", nationality='" + nationality + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentNumber=" + documentNumber +
                ", nif=" + nif +
                ", utenteNumber=" + utenteNumber +
                ", telemovel=" + telemovel +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}