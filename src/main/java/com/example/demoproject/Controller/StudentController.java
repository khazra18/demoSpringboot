package com.example.demoproject.Controller;

import com.example.demoproject.Entity.Student;
import com.example.demoproject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("getStudentByRollNumber/{rollNumber}")
    public ResponseEntity<Student> getStudentDetailsByRollNumber(@PathVariable int rollNumber){
        return new ResponseEntity<>(studentService.getStudentDetailsByRollNumber(rollNumber),HttpStatus.OK);
    }

    @GetMapping("getStudentDetailsByRollNumberAndMobile")
    public ResponseEntity<Student> getStudentDetailsByRollNumberAndMobile(@RequestParam int rollNumber,@RequestParam String mobile){
        return new ResponseEntity<>(studentService.getStudentDetailsByRollNumberAndMobile(rollNumber,mobile),HttpStatus.OK);
    }

    @PostMapping("addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
    }

}
