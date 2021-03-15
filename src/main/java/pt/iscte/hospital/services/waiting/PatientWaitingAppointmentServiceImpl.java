package pt.iscte.hospital.services.waiting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;
import pt.iscte.hospital.repositories.waiting.PatientWaitingAppointmentRepository;

import java.util.List;

@Service
public class PatientWaitingAppointmentServiceImpl implements PatientWaitingAppointmentService{

    @Autowired
    public PatientWaitingAppointmentRepository patientWaitingAppointmentRepository;

    @Override
    public void saveWaitingListRequest(PatientWaitingAppointment patientWaitingAppointment){
        patientWaitingAppointmentRepository.save(patientWaitingAppointment);

    }
    @Override
    public List<PatientWaitingAppointment> findAll(){
        return patientWaitingAppointmentRepository.findAll();
    }




}
