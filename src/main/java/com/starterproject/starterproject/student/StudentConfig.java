package com.starterproject.starterproject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student hans = new Student(
//                    "Hans",
//                    "hans@web.de",
//                    LocalDate.of(2000, Month.AUGUST, 14));
//
//            Student hanna = new Student(
//                    "Hanna",
//                    "hanna@web.de",
//                    LocalDate.of(2001, Month.APRIL, 15));
//
//            Student paul = new Student(
//                    "Paul",
//                    "paul@gmx.de",
//                    LocalDate.of(2004, Month.AUGUST, 4));
//
//            repository.saveAll(List.of(paul, hans, hanna));
//        };
//    }
}
