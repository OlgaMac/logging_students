package ru.aston.logging_students.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.logging_students.domain.entity.StudentEntity;
import ru.aston.logging_students.repository.StudentRepository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory factory;

    @Autowired
    public StudentRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    @Transactional(readOnly = true)
    public StudentEntity create(StudentEntity student) {

        Session session = factory.getCurrentSession();
        StudentEntity newStudent = new StudentEntity();
        newStudent.setName(student.getName());
        session.persist(newStudent);

        return newStudent;
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Long studentId) {
        Session session = factory.getCurrentSession();

        StudentEntity studentEntity;

        studentEntity = (StudentEntity) session.load(StudentEntity.class, studentId);
        session.delete(studentEntity);

    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentEntity> getAll() {
        Session session = factory.getCurrentSession();
        List<StudentEntity> students = session.createQuery("FROM StudentEntity ").list();

        return students;
    }
}

