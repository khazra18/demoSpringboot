package com.example.demoproject.Controller;

import com.example.demoproject.Entity.Student;
import com.example.demoproject.Model.ExceptionInfo;
import com.example.demoproject.Service.StudentService;
import com.example.demoproject.Utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/student/")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("inside getAllStudents");

        List<Student> studentList = studentService.getAllStudents();
        log.info("getAllStudents response {}", studentList);

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("getStudentByRollNumber/{rollNumber}")
    public ResponseEntity<Object> getStudentDetailsByRollNumber(@PathVariable int rollNumber) {
        Object obj = studentService.getStudentDetailsByRollNumber(rollNumber);
        log.info("getStudentByRollNumber - {}", obj);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("getStudentDetailsByRollNumberAndMobile")
    public ResponseEntity<Object> getStudentDetailsByRollNumberAndMobile(@RequestParam int rollNumber, @RequestParam String mobile) {
        Object obj = null;
        if (Utils.checkIfValidMobileNumber(mobile)) {
            obj = studentService.getStudentDetailsByRollNumberAndMobile(rollNumber, mobile);
            log.info("inside getStudentDetailsByRollNumberAndMobile if valid mobile number {}", obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            ExceptionInfo info = new ExceptionInfo();
            info.setDesc("Invalid roll number");
            info.setLocalDateTime(LocalDateTime.now());
            log.info("inside getStudentDetailsByRollNumberAndMobile if invalid mobile number {}", info);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }
    }

    @PostMapping("addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student s = studentService.createStudent(student);
        log.info("inside addStudent {}", s);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

}
