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
@Schema(name = "Создание студента", description = "Запрос для создания студента")
public class StudentRequest {
    @Schema(description = "Фамилия и Имя студента",
            maxLength = 255,
            minLength = 1,
            example = "someName")
    @NotBlank
    @Size(max = 255)
    private String name;

}
