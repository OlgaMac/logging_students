package ru.aston.logging_students.domain.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MessageRequestUpdate {

    private Long id;
    private String text;
}
