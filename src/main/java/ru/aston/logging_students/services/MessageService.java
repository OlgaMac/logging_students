package ru.aston.logging_students.services;

import org.springframework.stereotype.Service;
import ru.aston.logging_students.domain.entity.MessageEntity;

import java.util.List;

@Service
public interface MessageService {
    MessageEntity createNewMessage(Long studentId, String message);

    MessageEntity updateMessage(MessageEntity message);

    List<MessageEntity> getLogsByStudentId(Long studentId);
}
