package pt.iscte.hospital.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pt.iscte.hospital.security.Roles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "unit_responsible_id")
public class UnitResponsible extends Employee {
    // Attributes


    // Constructors
    public UnitResponsible() {
        super.setAccount("Responsável da Unidade");
    }

    public UnitResponsible(Long userId,
                   String name, String username,
                   String sex, Date birthday,
                   String address, String postCode,
                   String city,
                   String nationality, String documentType,
                   Long documentNumber, Long nif,
                   Long patientNumber, Long phone,
                   String email, String password, String photoURL) {
        super(userId, name, username, sex, birthday, address, postCode, city, nationality, documentType,
                documentNumber, nif, patientNumber, phone, email, password, photoURL);
        super.setAccount("Responsável da Unidade");
    }

    // Methods
    @Override
    public List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(Roles.ROLE_UNIT_RESPONSIBLE.name()));
        return roles;
    }

}
