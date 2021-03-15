package pt.iscte.hospital.services.waiting;

import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

import java.util.List;

public interface PatientWaitingAppointmentService {

    void saveWaitingListRequest(PatientWaitingAppointment patientWaitingAppointment);

    List<PatientWaitingAppointment> findAll();
}
