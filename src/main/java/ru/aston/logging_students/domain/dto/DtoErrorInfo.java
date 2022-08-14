package ru.aston.logging_students.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DtoErrorInfo {

    private LocalDateTime timestamp;

    private Integer status;

    private String error;

    private String exception;

    private String message;
}
