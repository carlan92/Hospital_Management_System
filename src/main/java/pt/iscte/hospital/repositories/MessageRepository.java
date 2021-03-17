package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Message;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByUserUserIdOrderByDateDesc(Long userId);
    List<Message> findAllByUserUserIdAndDateOrderByDateDesc(
            Long userId,
            LocalDate date);
    List<Message> findAllByUserUserIdAndDateAndReadMsgOrderByDateDesc(
            Long userId,
            LocalDate date,
            boolean hasRead);
    List<Message> findAllByUserUserIdAndReadMsgOrderByDateDesc(
            Long userId,
            boolean hasRead);
    Long countAllByUserUserIdAndReadMsg(Long userId, boolean hasRead);
    Message findByMessageId(Long messageId);
}
