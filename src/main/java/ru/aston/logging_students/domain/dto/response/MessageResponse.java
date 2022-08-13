package ru.aston.logging_students.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "Логи", description = "Информация о логе")
public class MessageResponse {
    @Schema(description = "Идентификатор сообщения",
            example = "1")
    private Long id;

    @Schema(description = "Идентификатор студента оставившего лог", example = "1")
    private Long studentId;

    @Schema(description = "Дата создания лога")
    private LocalDateTime created;

    @Schema(description = "Текст лога",
            maxLength = 500,
            minLength = 1,
            example = "some text")
    private String text;

}
