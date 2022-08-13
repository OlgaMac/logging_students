package ru.aston.logging_students.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.logging_students.domain.dto.request.StudentRequest;
import ru.aston.logging_students.domain.entity.StudentEntity;
import ru.aston.logging_students.domain.mapper.StudentMapper;
import ru.aston.logging_students.repository.StudentRepository;
import ru.aston.logging_students.repository.impl.StudentRepositoryImpl;
import ru.aston.logging_students.services.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentEntity createNewStudent(StudentEntity name) {
        return studentRepository.create(name);
    }

    @Override
    @Transactional
    public void deleteStudentById(Long studentId) {
        studentRepository.delete(studentId);
    }

    @Override
    @Transactional
    public List<StudentEntity> getAllStudents() {
        return studentRepository.getAll();
    }
}
