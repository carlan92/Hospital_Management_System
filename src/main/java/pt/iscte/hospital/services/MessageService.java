package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAllByUserUserIdOrderByDateTimeDesc(Long userId);
}
