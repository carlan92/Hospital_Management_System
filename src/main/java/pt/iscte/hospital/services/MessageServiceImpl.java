package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Message;
import pt.iscte.hospital.repositories.MessageRepository;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> findAllByUserUserIdOrderByDateTimeDesc(Long userId){
        return messageRepository.findAllByUserUserIdOrderByDateTimeDesc(userId);
    }
}
