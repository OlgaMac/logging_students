package ru.aston.logging_students.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_students_id")
    @GenericGenerator(name = "seq_students_id", strategy = "sequence",
            parameters = {@Parameter(name = "sequence", value = "seq_students_id")})
    private Long id;
    private String name;
    @JsonIgnore
    @Setter(PRIVATE)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MessageEntity> logs = new ArrayList<>();

    public void addLog(MessageEntity messageEntity) {
        this.logs.add(messageEntity);
        messageEntity.setStudent(this);
    }
}
