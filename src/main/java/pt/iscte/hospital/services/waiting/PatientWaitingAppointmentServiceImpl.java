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

    @Override
    public List<PatientWaitingAppointment> findAllByPatientUserIdAndClosed(long userId, boolean closed){
        return patientWaitingAppointmentRepository.findAllByPatientUserIdAndClosed(userId, closed);
    }
    @Override
    public List<PatientWaitingAppointment> findAllByClosed(boolean closed){
        return patientWaitingAppointmentRepository.findAllByClosed(closed);
    }

    @Override
    public List<PatientWaitingAppointment> findAllByClosedAndRepliedToOffer(
            boolean closed,
            boolean repliedToOffer){
        return patientWaitingAppointmentRepository.findAllByClosedAndRepliedToOffer(closed, repliedToOffer);
    }

    @Override
    public void save(PatientWaitingAppointment patientWaitingAppointment){
        patientWaitingAppointmentRepository.save(patientWaitingAppointment);
    }

    @Override
    public List<PatientWaitingAppointment> findAllByClosedOrderByDate(boolean closed){
        return patientWaitingAppointmentRepository.findAllByClosedOrderByDate(closed);
    }

    @Override
    public PatientWaitingAppointment findByPatientWaitingAppointmentId(Long patientWaitingAppointmentId){
        return patientWaitingAppointmentRepository.findByPatientWaitingAppointmentId(patientWaitingAppointmentId);
    }


}
