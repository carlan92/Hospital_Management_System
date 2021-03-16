package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.repositories.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> findAllByUserUserIdOrderByDateTimeDesc(Long userId) {
        return messageRepository.findAllByUserUserIdOrderByDateTimeDesc(userId);
    }

    @Override
    public List<Message> findAllByUserUserIdAndDateTimeOrderByDateTimeDesc(Long userId, LocalDateTime dateTime) {
        return messageRepository.findAllByUserUserIdAndDateTimeOrderByDateTimeDesc(userId, dateTime);
    }

    @Override
    public List<Message> findAllByUserUserIdAndDateTimeAndReadMsgOrderByDateTimeDesc(
            Long userId,
            LocalDateTime dateTime,
            boolean hasRead) {
        return messageRepository.findAllByUserUserIdAndDateTimeAndReadMsgOrderByDateTimeDesc(
                userId,
                dateTime,
                hasRead);
    }

    @Override
    public List<Message> findAllByUserUserIdAndReadMsgOrderByDateTimeDesc(
            Long userId,
            boolean hasRead) {
        return messageRepository.findAllByUserUserIdAndReadMsgOrderByDateTimeDesc(
                userId,
                hasRead);
    }

    @Override
    public Long countAllByUserUserIdAndReadMsg(
            Long userId,
            boolean hasRead){
        return messageRepository.countAllByUserUserIdAndReadMsg(
                userId,
                hasRead);
    }

    @Override
    public void createMessage(String subject, String message, User userReceiver){
        save(new Message(subject, message, userReceiver));
    }

    @Override
    public void deleteMessageById(Long msgId){
        Message msg = messageRepository.findByMessageId(msgId);
        delete(msg);
    }

    @Override
    public void markMessageHasReadById(Long msgId){
        Message msg = messageRepository.findByMessageId(msgId);
        msg.setReadMsg(true);
        save(msg);
    }

    @Override
    public boolean hasUnreadMessages(Long userId){
        Long count = messageRepository.countAllByUserUserIdAndReadMsg(userId, false);
        return count != 0;
    }

    @Override
    public void save(Message message){
        messageRepository.save(message);
    }

    @Override
    public void delete(Message message){
        messageRepository.delete(message);
    }
}
