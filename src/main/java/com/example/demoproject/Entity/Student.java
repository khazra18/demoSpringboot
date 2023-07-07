package com.example.demoproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(StudentCompositeId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    private int rollNumber;

    @Id
    private String mobile;

    private String name;
    private String className;
    private String section;

}
