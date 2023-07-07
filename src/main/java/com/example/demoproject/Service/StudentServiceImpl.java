package com.example.demoproject.Service;

import com.example.demoproject.Entity.Student;
import com.example.demoproject.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentDetailsById(int rollNumber) {
        Optional<Student> student = studentRepository.findById(rollNumber);
        return student.orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentDetails(Student student) {

        Student studentRepo = studentRepository.findById(student.getRollNumber()).orElse(null);
        if (studentRepo!= null){
            studentRepo.setName(student.getName());
            studentRepo.setSection(student.getSection());
            studentRepo.setClassName(student.getClassName());
        }

        return studentRepo;
    }

    @Override
    public void deleteStudent(int rollNumber) {
        studentRepository.deleteById(rollNumber);
    }
}
