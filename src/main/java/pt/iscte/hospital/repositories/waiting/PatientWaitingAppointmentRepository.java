package pt.iscte.hospital.repositories.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.iscte.hospital.entities.waiting.PatientWaitingAppointment;

import java.util.List;

@Repository
public interface PatientWaitingAppointmentRepository extends JpaRepository<PatientWaitingAppointment, Long> {
    List<PatientWaitingAppointment> findAll();

    List<PatientWaitingAppointment> findAllByPatientUserIdAndClosed(long userId, boolean closed);

    List<PatientWaitingAppointment> findAllByClosed(boolean closed);

    List<PatientWaitingAppointment> findAllByClosedAndRepliedToOffer(boolean closed, boolean repliedToOffer);

    List<PatientWaitingAppointment> findAllByClosedOrderByDate(boolean closed);

    PatientWaitingAppointment findByPatientWaitingAppointmentId(Long patientWaitingAppointmentId);

}
