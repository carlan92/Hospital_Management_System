package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.PatientRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    PatientRepository patientRepository;


    public boolean validaNome(User user) {
        String[] names = user.getName().split(" ");
        for (int i = 0; i < names.length; i++) {
            if (!names[i].matches("[A-ZÀ-Ÿa-zÀ-ÿ']{2,}||[e]{1}")) {
                return false;
            }
        }
        return true;
    }

    public boolean validaTelefone(User user) {
        String phone = String.valueOf(user.getPhone());
        if (!phone.matches("^9[1236][0-9]{7}$|^2[3-9][1-9][0-9]{6}$|^2[12][0-9]{7}$")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaPassword(User user) {
        //para mais tarde repensar nas limitações
        if (!user.getPassword().matches(".{1,15}")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaPostCode(User user) {
        if (!user.getPostCode().matches("[0-9]{4}[-][0-9]{3}")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaSexo(User user) {
        if (user.getSex().matches("Feminino") || user.getSex().matches("Masculino")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validaEmail(User user) {
        User userUnique = patientRepository.findByEmail(user.getEmail());
        if (userUnique != null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaUsername(User user) {
        User userUnique = patientRepository.findByUsername(user.getUsername());
        if (userUnique != null) {
            return false;
        } else {
            return true;
        }
    }

}
