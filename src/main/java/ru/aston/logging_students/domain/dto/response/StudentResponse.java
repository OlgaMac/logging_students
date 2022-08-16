package ru.aston.logging_students.domain.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class StudentResponse {

    private Long id;

    private String name;

    private List<Long> logIds;
}
