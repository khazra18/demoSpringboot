package com.example.demoproject;

import com.example.demoproject.Entity.Student;
import com.example.demoproject.ExceptionModel.StudentNotFoundException;
import com.example.demoproject.Repository.StudentRepository;
import com.example.demoproject.Service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceExceptionTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach()
    public void setup() {
        student = new Student(1, "1234567890", "abc", "1", "A");
    }

    @Test
    @DisplayName("StudentNotFoundExceptionTest")
    public void StudentNotFoundExceptionTest(){

        studentService.createStudent(student);
        assertThrows(StudentNotFoundException.class,() -> studentService.getStudentDetailsByRollNumberAndMobile(2,"123"),
                () -> "Exception");

    }

}
