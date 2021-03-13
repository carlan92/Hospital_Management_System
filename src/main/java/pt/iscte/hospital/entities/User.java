package pt.iscte.hospital.entities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import pt.iscte.hospital.objects.utils.Calendar;
import pt.iscte.hospital.objects.utils.HostpitalFormatter;
import pt.iscte.hospital.security.Role;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String username;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String address;
    private String postCode;
    private String city;
    private String account;
    private String nationality;
    private String documentType;
    private Long documentNumber;
    private Long nif;
    private Long patientNumber;
    private Long phone;
    private String email;
    private String password;
    private String photoURL;

    // Constructors
    public User() {
    }

    public User(Long userId,
                String name,
                String username, String sex, LocalDate birthday, String address,
                String postCode, String city, String nationality, String documentType,
                Long documentNumber, Long nif, Long patientNumber, Long phone,
                String email, String password, String photoURL) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.nationality = nationality;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.nif = nif;
        this.patientNumber = patientNumber;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.photoURL = photoURL;
    }

    // Methods
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstAndLastName() {
        String[] names = name.split(" ");
        if (names.length > 1) {
            return names[0] + " " + names[names.length - 1];
        } else {
            return names[0];
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        LocalDate todayDate = LocalDate.now();
        return Period.between(birthday, todayDate).getYears();
    }

    public String getBirthdayStr() {
        if (birthday == null) {
            return "";
        }

        return birthday.format(Calendar.FORMATTER);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Long getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(Long patientNumber) {
        this.patientNumber = patientNumber;
    }

    public Long getPhone() {
        return phone;
    }

    public String getPhoneStr() {
        return HostpitalFormatter.formatValue(phone, HostpitalFormatter.PHONE);
    }

    public void setPhone(Long phone) {
        this.phone = phone;
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

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public abstract List<GrantedAuthority> getAuthorities();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", account='" + account + '\'' +
                ", nationality='" + nationality + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentNumber=" + documentNumber +
                ", nif=" + nif +
                ", patientNumber=" + patientNumber +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }
}
