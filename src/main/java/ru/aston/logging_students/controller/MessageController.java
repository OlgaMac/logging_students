package ru.aston.logging_students.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.logging_students.domain.dto.DtoErrorInfo;
import ru.aston.logging_students.domain.dto.request.MessageRequestUpdate;
import ru.aston.logging_students.domain.dto.response.MessageResponse;
import ru.aston.logging_students.domain.dto.response.StudentResponse;
import ru.aston.logging_students.domain.entity.MessageEntity;
import ru.aston.logging_students.domain.mapper.MessageMapper;
import ru.aston.logging_students.services.MessageService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Autowired
    public MessageController(MessageService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @ApiOperation(value = "Получение всех логов для студента")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Kjub найдены",
            response = List.class),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера",
                    response = DtoErrorInfo.class)})
    @GetMapping("/student")
    public ResponseEntity<List<MessageResponse>> getAllLogs(@RequestParam Long studentId) {
        List<MessageResponse> messages = messageService.getLogsByStudentId(studentId).stream()
                .map(messageMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(messages, OK);
    }

    @ApiOperation(value = "Создание лога")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Лог создан", response = StudentResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации", response = DtoErrorInfo.class),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера", response = DtoErrorInfo.class)})
    @PostMapping("/newlog")
    public ResponseEntity<MessageResponse> createNewLogs(@RequestParam Long id, @RequestParam String message) {
        MessageEntity messageEntity = messageService.createNewMessage(id, message);
        MessageResponse messageResponse = Optional.ofNullable(messageEntity)
                .map(messageMapper::toResponse)
                .orElseThrow();
        return new ResponseEntity<>(messageResponse, CREATED);
    }

    @ApiOperation(value = "Обновление лога")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Лог обнавлен", response = StudentResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации", response = DtoErrorInfo.class),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера", response = DtoErrorInfo.class)})
    @PostMapping("/updatelog")
    public ResponseEntity<MessageResponse> updateLog(@RequestBody @Valid MessageRequestUpdate messageRequest) {
        MessageResponse messageResponse = Optional.ofNullable(messageRequest)
                .map(messageMapper::fromRequestUpdate)
                .map(messageService::updateMessage)
                .map(messageMapper::toResponse)
                .orElseThrow();
        return new ResponseEntity<>(messageResponse, OK);
    }
}
