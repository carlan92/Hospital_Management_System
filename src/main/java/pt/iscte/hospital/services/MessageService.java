package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageService {
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

    void createMessage(String subject, String message, User userReceiver);

    void deleteMessageById(Long msgId);

    void markMessageHasReadById(Long msgId);

    boolean hasUnreadMessages(Long userId);

    void save(Message message);

    void delete(Message message);

}
