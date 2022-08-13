package ru.aston.logging_students.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "Обновление студента", description = "Запрос для обновления студента")
public class StudentRequestUpdate {

    @Schema(description = "Фамилия и Имя пользователя",
            maxLength = 255,
            minLength = 1,
            example = "someName upd")
    @Size(max = 255)
    private String name;
}
