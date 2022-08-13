package ru.aston.logging_students.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private String text;
}
