package pt.iscte.hospital.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Doctor;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.entities.states.AppointmentState;
import pt.iscte.hospital.repositories.AppointmentRepository;
import pt.iscte.hospital.repositories.user.DoctorRepository;
import pt.iscte.hospital.repositories.SpecialityRepository;
import pt.iscte.hospital.services.user.DoctorService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    //Methods
    @Override
    public void chamarUtente(Doctor doctor) {
        // Consultar a base de dados: por médico, por data, por checking
        //TODO

    }

    @Override
    public void startAppointment(Appointment appointment) {
        appointment.setAppointmentStatus(AppointmentState.EM_CURSO.getStateNr());
        appointment.setDate(LocalDate.now());
        appointment.setTimeBegin(LocalTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public void endAppointment(Appointment appointment) {
        appointment.setAppointmentStatus(AppointmentState.REALIZADA.getStateNr());
        appointment.setTimeEnd(LocalTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public void marcarFalta(Appointment appointment) {
        appointment.setAppointmentStatus(AppointmentState.NAO_REALIZADA.getStateNr());
        appointmentRepository.save(appointment);
    }

    @Override
    public void removerFalta(Appointment appointment) {
        appointment.setAppointmentStatus(AppointmentState.EM_CURSO.getStateNr());
        appointment.setTimeBegin(LocalTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public void verListaDeEspera() {

    }

    @Override
    public void desmarcarConsultaByDoctor(Appointment appointment) {
        appointment.setAppointmentStatus(AppointmentState.DESMARCADA_PELO_MEDICO.getStateNr());
        appointmentRepository.save(appointment);
    }

    @Override
    public Doctor findByUserId(Long doctorId) {
        return doctorRepository.findByUserId(doctorId);
    }

    @Override
    public List<Doctor> findAll(Sort sort) {
        return doctorRepository.findAll(sort);
    }

    @Override
    public List<Doctor> findAllBySpeciality(String specialityName) {
        Speciality speciality = specialityRepository.findByName(specialityName);
        return doctorRepository.findAllBySpeciality(speciality);
    }

    @Override
    public List<Doctor> findAllBySpecialityOrderByNameAsc(Speciality speciality) {
        return doctorRepository.findAllBySpecialityOrderByNameAsc(speciality);
    }

    @Override
    public List<Doctor> findAllByNameContainingIgnoreCase(String name) {
        return doctorRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Doctor> findAllByNameContainingIgnoreCaseAndSpeciality(String name, String specialityName) {
        Speciality speciality = specialityRepository.findByName(specialityName);
        return doctorRepository.findAllByNameContainingIgnoreCaseAndSpeciality(name, speciality);
    }

    @Override
    public List<Doctor> findAllByFirstAndLastName(String name) {
        List<Doctor> doctors = doctorRepository.findAllByNameContainingIgnoreCase(name);
        return filterByFirstAndLastName(name, doctors);
    }

    @Override
    public List<Doctor> findAllByFirstAndLastNameAndSpeciality(String name, String specialityName) {
        Speciality speciality = specialityRepository.findByName(specialityName);
        List<Doctor> doctors = doctorRepository.findAllByNameContainingIgnoreCaseAndSpeciality(name, speciality);
        return filterByFirstAndLastName(name, doctors);
    }

    private List<Doctor> filterByFirstAndLastName(String name, List<Doctor> doctors) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getFirstAndLastName().toLowerCase().contains(name.toLowerCase())) {
                result.add(doctor);
            }
        }
        return result;
    }

}
