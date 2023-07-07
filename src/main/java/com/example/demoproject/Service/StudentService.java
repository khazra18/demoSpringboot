package com.example.demoproject.Service;

import com.example.demoproject.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();
    public Student getStudentDetailsById(int rollNumber);
    public Student createStudent(Student student);
    public Student updateStudentDetails(Student student);
    public void deleteStudent(int rollNumber);

}
