package ru.aston.logging_students.services;

import org.springframework.stereotype.Service;
import ru.aston.logging_students.domain.dto.request.StudentRequest;
import ru.aston.logging_students.domain.entity.StudentEntity;

import java.util.List;
@Service
public interface StudentService {
    StudentEntity createNewStudent(StudentEntity name);

    void deleteStudentById(Long studentId);

    List<StudentEntity> getAllStudents();
}
