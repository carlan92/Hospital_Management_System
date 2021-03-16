package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Message;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByUserUserIdOrderByDateTimeDesc(Long userId);
    List<Message> findAllByUserUserIdAndDateTimeOrderByDateTimeDesc(
            Long userId,
            LocalDateTime dateTime);
    List<Message> findAllByUserUserIdAndDateTimeAndReadMsgOrderByDateTimeDesc(
            Long userId,
            LocalDateTime dateTime,
            boolean hasRead);
    List<Message> findAllByUserUserIdAndReadMsgOrderByDateTimeDesc(
            Long userId,
            boolean hasRead);
    Long countAllByUserUserIdAndReadMsg(Long userId, boolean hasRead);
}
