package com.example.demoproject;

import com.example.demoproject.Entity.Student;
import com.example.demoproject.Repository.StudentRepository;
import com.example.demoproject.Service.StudentServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

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
    @DisplayName("getAllStudentsTest")
    public void getAllStudentsTest() {

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        when(studentRepository.findAll()).thenReturn(studentList);

        assertEquals(1,studentService.getAllStudents().size());

    }

    @Test
    @DisplayName("getStudentDetailsByRollNumberTest")
    public void getStudentDetailsByRollNumberTest(){

        when(studentRepository.getStudentByRollNumber(anyInt())).thenReturn(student);
        assertEquals("1",studentService.getStudentDetailsByRollNumber(anyInt()).getClassName());

    }

    @Test
    @DisplayName("getStudentDetailsByRollNumberAndMobileTest")
    public void getStudentDetailsByRollNumberAndMobileTest(){

        when(studentRepository.getStudentDetailsByRollNumberAndMobile(anyInt(),anyString())).thenReturn(student);
        assertEquals("1",studentService.getStudentDetailsByRollNumberAndMobile(anyInt(),anyString()).getClassName());

    }

    @Test
    @DisplayName("updateStudentDetailsTest")
    public void updateStudentDetailsTest(){

        when(studentRepository.findById(anyInt())).thenReturn(Optional.ofNullable(student));
        assertEquals("1",studentService.updateStudentDetails(student).getClassName());

    }

    @Test
    @DisplayName("deleteStudentTest")
    public void deleteStudentTest(){

        // for given input
        final Integer id = 1;
        // when the desired action performed
        studentService.deleteStudent(id);
        // then verify
        Mockito.verify(studentRepository).deleteById(id);

    }

    @Test
    @DisplayName("createStudentTest")
    public void createStudentTest(){

        Student student1 = new Student(2, "1234567890", "abc", "1", "A");
        when(studentRepository.save(student1)).thenReturn(student1);
        Student student2 = studentService.createStudent(student1);
        assertEquals(2,student2.getRollNumber());
    }


}
