package com.example.demoproject.Repository;

import com.example.demoproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("select s from Student s where s.rollNumber = ?1")
    Student getStudentByRollNumber(int rollNumber);

    @Query("select s from Student s where s.rollNumber = ?1 and s.mobile = ?2")
    Student getStudentDetailsByRollNumberAndMobile(int rollNumber,String mobile);

}
