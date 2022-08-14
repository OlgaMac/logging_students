package ru.aston.logging_students.domain.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.aston.logging_students.utils.LocalDateDeserializer;
import ru.aston.logging_students.utils.LocalDateSerializer;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MessageResponse {

    private Long id;

    private Long studentId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate created;

    private String text;

}
