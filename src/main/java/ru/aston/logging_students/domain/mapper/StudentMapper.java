package ru.aston.logging_students.domain.mapper;

import org.springframework.stereotype.Component;
import ru.aston.logging_students.domain.dto.request.StudentRequest;
import ru.aston.logging_students.domain.dto.request.StudentRequestUpdate;
import ru.aston.logging_students.domain.dto.response.StudentResponse;
import ru.aston.logging_students.domain.entity.StudentEntity;

public interface StudentMapper {


    StudentResponse toResponse(StudentEntity studentEntity);

    StudentEntity fromRequest(StudentRequest studentRequest);

    StudentEntity fromRequestUpdate(StudentRequestUpdate studentRequestUpdate);

    StudentEntity merge(StudentEntity source, StudentEntity target);
}
