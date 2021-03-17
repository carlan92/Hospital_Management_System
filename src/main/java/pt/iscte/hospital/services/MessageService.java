package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface MessageService {
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

    void createMessage(String subject, String message, User userReceiver);

    void deleteMessageById(Long msgId);

    void markMessageHasReadById(Long msgId);

    boolean hasUnreadMessages(Long userId);

    void save(Message message);

    void delete(Message message);

}
