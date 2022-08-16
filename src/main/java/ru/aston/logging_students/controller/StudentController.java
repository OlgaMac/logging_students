package ru.aston.logging_students.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.logging_students.domain.dto.DtoErrorInfo;
import ru.aston.logging_students.domain.dto.request.StudentRequest;
import ru.aston.logging_students.domain.dto.response.StudentResponse;
import ru.aston.logging_students.domain.mapper.StudentMapper;
import ru.aston.logging_students.services.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @ApiOperation(value = "Получение всех студентов")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Студенты найдены",
            response = List.class),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера",
                    response = DtoErrorInfo.class)})
    @GetMapping
    public ResponseEntity<List<StudentResponse>> findAll() {
        List<StudentResponse> students = studentService.getAllStudents().stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(students, OK);
    }

    @ApiOperation(value = "Создание студента")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Студент создан", response = StudentResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации", response = DtoErrorInfo.class),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера", response = DtoErrorInfo.class)})
    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody @Valid StudentRequest studentRequest) {
        StudentResponse studentResponse = Optional.ofNullable(studentRequest)
                .map(studentMapper::fromRequest)
                .map(studentService::createNewStudent)
                .map(studentMapper::toResponse)
                .orElseThrow();
        return new ResponseEntity<>(studentResponse, CREATED);
    }

    @ApiOperation(value = "Удаление студента")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Студент удален"),
            @ApiResponse(code = 400, message = "Внутренняя ошибка сервера",
                    response = DtoErrorInfo.class),
            @ApiResponse(code = 404, message = "Студент не найден",
                    response = DtoErrorInfo.class)})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(OK);
    }
}
