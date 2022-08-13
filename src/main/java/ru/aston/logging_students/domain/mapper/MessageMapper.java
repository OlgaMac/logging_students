package ru.aston.logging_students.domain.mapper;

import org.springframework.stereotype.Component;
import ru.aston.logging_students.domain.dto.request.MessageRequest;
import ru.aston.logging_students.domain.dto.request.MessageRequestUpdate;
import ru.aston.logging_students.domain.dto.response.MessageResponse;
import ru.aston.logging_students.domain.entity.MessageEntity;

public interface MessageMapper {

    MessageResponse toResponse(MessageEntity source);

    MessageEntity fromRequest(MessageRequest source);

    MessageEntity fromRequestUpdate(MessageRequestUpdate source);

    MessageEntity merge(MessageEntity source, MessageEntity target);
}
