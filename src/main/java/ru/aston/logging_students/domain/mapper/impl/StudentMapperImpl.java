package ru.aston.logging_students.domain.mapper.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aston.logging_students.domain.dto.request.StudentRequest;
import ru.aston.logging_students.domain.dto.request.StudentRequestUpdate;
import ru.aston.logging_students.domain.dto.response.StudentResponse;
import ru.aston.logging_students.domain.entity.MessageEntity;
import ru.aston.logging_students.domain.entity.StudentEntity;
import ru.aston.logging_students.domain.mapper.StudentMapper;

import java.util.stream.Collectors;

@Component
public class StudentMapperImpl implements StudentMapper {

    private final ObjectMapper objectMapper;

    @Autowired
    public StudentMapperImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public StudentResponse toResponse(StudentEntity studentEntity) {
        StudentResponse result = new StudentResponse();
        return result
                .setId(studentEntity.getId())
                .setName(studentEntity.getName())
                .setLogIds(studentEntity.getLogs()
                        .stream()
                        .map(MessageEntity::getId)
                        .collect(Collectors.toList()));
    }

    @Override
    public StudentEntity fromRequest(StudentRequest studentRequest) {
        return objectMapper.convertValue(studentRequest, StudentEntity.class);
    }

    @Override
    public StudentEntity fromRequestUpdate(StudentRequestUpdate studentRequestUpdate) {
        return objectMapper.convertValue(studentRequestUpdate, StudentEntity.class);
    }

    @Override
    public StudentEntity merge(StudentEntity source, StudentEntity target) {

        if (source.getName() != null) {
            target.setName(source.getName());
        }
        return target;
    }
}
