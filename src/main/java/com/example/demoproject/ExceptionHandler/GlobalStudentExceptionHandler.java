package com.example.demoproject.ExceptionHandler;

import com.example.demoproject.ExceptionModel.StudentNotFoundException;
import com.example.demoproject.Model.ExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalStudentExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    private ResponseEntity<ExceptionInfo> studentNotFoundException(StudentNotFoundException studentNotFoundException){

        ExceptionInfo info = new ExceptionInfo();
        info.setDesc(studentNotFoundException.getMessage());
        info.setLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);

    }



}
