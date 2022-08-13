package ru.aston.logging_students.services.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.logging_students.domain.entity.MessageEntity;
import ru.aston.logging_students.domain.entity.StudentEntity;
import ru.aston.logging_students.repository.MessageRepository;

import ru.aston.logging_students.services.MessageService;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    @Transactional
    public MessageEntity createNewMessage(Long studentId, String message) {
        return messageRepository.create(studentId,message);
    }

    @Override
    @Transactional
    public MessageEntity updateMessage(MessageEntity message) {
        return messageRepository.update(message);
    }

    @Override
    @Transactional
    public List<MessageEntity> getLogsByStudentId(Long studentId) {
        return messageRepository.getLogs(studentId);
    }

}
