package pt.iscte.hospital.services.user;

import org.springframework.data.domain.Sort;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;

import java.util.List;

public interface DoctorService {
    void chamarUtente(Doctor doctor);
    void startAppointment(Appointment appointment);
    void endAppointment(Appointment appointment);
    void marcarFalta(Appointment appointment);
    void removerFalta(Appointment appointment);
    void verListaDeEspera();
    void desmarcarConsultaByDoctor(Appointment appointment);
    Doctor findByUserId(Long doctorId);
    List<Doctor> findAll(Sort sort);
    List<Doctor> findAllBySpeciality(String specialityName);
    List<Doctor> findAllBySpecialityOrderByNameAsc(Speciality speciality);
    List<Doctor> findAllByNameContainingIgnoreCase(String name);
    List<Doctor> findAllByNameContainingIgnoreCaseAndSpeciality(String name, String specialityName);
    List<Doctor> findAllByFirstAndLastName(String name);
    List<Doctor> findAllByFirstAndLastNameAndSpeciality(String name, String specialityName);

}
