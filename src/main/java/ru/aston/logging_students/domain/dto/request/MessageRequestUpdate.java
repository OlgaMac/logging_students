package ru.aston.logging_students.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@Schema(name = "Обновление лога", description = "Запрос для обновления лога")
public class MessageRequestUpdate {
    @Schema(description = "Id лога",
            maxLength = 1000,
            minLength = 1,
            example = "45")
    @Size(max = 1000)
    private Long id;
    @Schema(description = "Текст лога",
            maxLength = 500,
            minLength = 1,
            example = "some text upd")
    @Size(max = 500)
    private String text;
}
