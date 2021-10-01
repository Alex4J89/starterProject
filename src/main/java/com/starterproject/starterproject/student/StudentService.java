package com.starterproject.starterproject.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(new Student(1L,
                "Hans",
                "hans@web.de",
                LocalDate.of(1989, 5, 14),
                25));

    }
}
