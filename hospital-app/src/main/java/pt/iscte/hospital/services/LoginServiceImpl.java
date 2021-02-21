package pt.iscte.hospital.services;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Override
    public boolean validateLogin(String username, String password){
        if(username.equals("quimBarreiros")&& password.equals("bacalhau")){
            return true;
        }
        return false;
    }
}
