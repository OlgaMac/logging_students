package ru.aston.logging_students.repository;

import org.springframework.stereotype.Repository;
import ru.aston.logging_students.domain.dto.request.StudentRequest;
import ru.aston.logging_students.domain.entity.StudentEntity;

import java.util.List;

@Repository
public interface StudentRepository {

    StudentEntity create(StudentEntity name);

    void delete(Long studentId);

    List<StudentEntity> getAll();


}
