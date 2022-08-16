package ru.aston.logging_students.repository;

import ru.aston.logging_students.domain.entity.MessageEntity;
import ru.aston.logging_students.domain.entity.StudentEntity;

import java.util.List;

public interface MessageRepository {
    MessageEntity create(Long studentId,String message);

    MessageEntity update(MessageEntity message);

    List<MessageEntity> getLogs(Long studentId);
}
