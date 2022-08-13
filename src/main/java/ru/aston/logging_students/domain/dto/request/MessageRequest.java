package ru.aston.logging_students.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "Создание лога", description = "Запрос для создания лога")
public class MessageRequest {
    @Schema(description = "Текст лога",
            maxLength = 500,
            minLength = 1,
            example = "some text")
    @NotBlank
    @Size(max = 500)
    private String text;

}
