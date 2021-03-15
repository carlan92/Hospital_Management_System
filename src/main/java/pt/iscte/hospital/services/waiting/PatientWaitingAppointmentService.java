package pt.iscte.hospital.services.waiting;

import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

public interface PatientWaitingAppointmentService {

    void saveWaitingListRequest(PatientWaitingAppointment patientWaitingAppointment);
}
