package pt.iscte.hospital.services;

import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.User;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    public boolean validaNome(User user) {
        String[] names = user.getName().split(" ");
        for (int i = 0; i < names.length; i++) {
            if (!names[i].matches("[A-ZÀ-Ÿa-zÀ-ÿ']{2,}||[e]{1}")) {
                return false;
            }
        }
        return true;
    }
    public boolean validaTelefone(User user){
        String phone=String.valueOf(user.getPhone());
        if(!phone.matches("[1236][0-9]{7}$|^2[3-9][1-9][0-9]{6}$|^2[12][0-9]{7}")){
            return false;
        }
        return true;
    }
}
