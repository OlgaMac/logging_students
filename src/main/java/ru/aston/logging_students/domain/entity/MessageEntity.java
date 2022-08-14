package ru.aston.logging_students.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import ru.aston.logging_students.utils.LocalDateDeserializer;
import ru.aston.logging_students.utils.LocalDateSerializer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages")
@JsonIgnoreProperties
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_messages_id")
    @GenericGenerator(name = "seq_messages_id", strategy = "sequence",
            parameters = {@Parameter(name = "sequence", value = "seq_messages_id")})
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    private String text;
}
