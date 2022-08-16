package ru.aston.logging_students.domain.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aston.logging_students.domain.dto.request.MessageRequest;
import ru.aston.logging_students.domain.dto.request.MessageRequestUpdate;
import ru.aston.logging_students.domain.dto.response.MessageResponse;
import ru.aston.logging_students.domain.entity.MessageEntity;
import ru.aston.logging_students.domain.mapper.MessageMapper;

@Component
public class MessageMapperImpl implements MessageMapper {

    private final ObjectMapper objectMapper;

    @Autowired
    public MessageMapperImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public MessageResponse toResponse(MessageEntity messageEntity) {
        MessageResponse result = new MessageResponse();
        return result.setId(messageEntity.getId())
                .setStudentId(messageEntity.getStudent().getId())
                .setCreated(messageEntity.getDate())
                .setText(messageEntity.getText());
    }

    @Override
    public MessageEntity fromRequest(MessageRequest source) {
        return objectMapper.convertValue(source, MessageEntity.class);
    }

    @Override
    public MessageEntity fromRequestUpdate(MessageRequestUpdate source) {
        return objectMapper.convertValue(source, MessageEntity.class);
    }

    @Override
    public MessageEntity merge(MessageEntity source, MessageEntity target) {
        if (source.getText() != null) {
            target.setText(source.getText());
        }
        return target;
    }
}
