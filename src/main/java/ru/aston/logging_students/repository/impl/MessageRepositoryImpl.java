package ru.aston.logging_students.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.logging_students.domain.entity.MessageEntity;
import ru.aston.logging_students.domain.entity.StudentEntity;
import ru.aston.logging_students.repository.MessageRepository;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final SessionFactory factory;

    @Autowired
    public MessageRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    @Transactional
    public MessageEntity create(Long studentId, String message) {
        Session session = factory.getCurrentSession();
        StudentEntity student = findById(studentId);
        MessageEntity newMessage = new MessageEntity();
        newMessage.setStudent(student);
        newMessage.setDate(LocalDateTime.now());
        newMessage.setText(message);
        session.persist(newMessage);

        return newMessage;
    }

    @Override
    @Transactional
    public MessageEntity update(MessageEntity message) {
        Session session = factory.getCurrentSession();
        MessageEntity updateMessage = findByIdLog(message.getId());
        updateMessage.setId(message.getId());
        updateMessage.setStudent(updateMessage.getStudent());
        updateMessage.setDate(LocalDateTime.now());
        updateMessage.setText(message.getText());
        session.save(updateMessage);

        return updateMessage;
    }


    @Override
    @Transactional
    public List<MessageEntity> getLogs(Long studentId) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("FROM MessageEntity m WHERE m.student.id = :studentId");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public StudentEntity findById(Long studentId) {
        Session session = factory.getCurrentSession();
        return session.get(StudentEntity.class, studentId);
    }

    @Transactional(readOnly = true)
    public MessageEntity findByIdLog(Long id) {
        Session session = factory.getCurrentSession();
        return session.get(MessageEntity.class, id);
    }
}
