package com.spring.security.student;


import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "Saul Figueroa"),
            new Student(2, "Thomas Albert"),
            new Student(3, "John Smith")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable(name = "studentId") Integer studentId){
            return students.stream()
                    .filter(student -> studentId.equals(student.getStudentId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Student "+studentId+" does not exist"));
    }

}
