package ru.aston.logging_students.domain.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "Студент", description = "Информация о студенте")
public class StudentResponse {
    @Schema(description = "Идентификатор студента",
            example = "1")
    private Long id;
    @Schema(description = "Имя студента",
            maxLength = 255,
            minLength = 1,
            example = "someName")
    private String name;
    @Schema(description = "Список идентификаторов логов студента", example = "[1, 2, 3]")
    private List<Long> logIds;
}
