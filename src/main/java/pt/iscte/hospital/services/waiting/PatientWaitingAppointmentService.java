package pt.iscte.hospital.services.waiting;

import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

import java.util.List;

public interface PatientWaitingAppointmentService {

    void saveWaitingListRequest(PatientWaitingAppointment patientWaitingAppointment);

    List<PatientWaitingAppointment> findAll();

    List<PatientWaitingAppointment> findAllByClosed(boolean closed);

    List<PatientWaitingAppointment> findAllByClosedAndRepliedToOffer(boolean closed, boolean repliedToOffer);

    List<PatientWaitingAppointment> findAllByPatientUserIdAndClosed(long userId, boolean closed);

    void save(PatientWaitingAppointment patientWaitingAppointment);

    List<PatientWaitingAppointment> findAllByClosedOrderByDate(boolean closed);

    PatientWaitingAppointment findByPatientWaitingAppointmentId(Long patientWaitingAppointmentId);
}
