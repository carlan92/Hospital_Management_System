package pt.iscte.hospital.services.waiting;

import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

import java.util.List;

public interface PatientWaitingAppointmentService {

    void saveWaitingListRequest(PatientWaitingAppointment patientWaitingAppointment);

    List<PatientWaitingAppointment> findAll();

    List<PatientWaitingAppointment> findAllByClosed(boolean closed);

    List<PatientWaitingAppointment> findAllByPatientUserIdAndClosed(long userId, boolean closed);

    void save(PatientWaitingAppointment patientWaitingAppointment);
}
