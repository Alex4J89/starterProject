package com.starterproject.starterproject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student hans = new Student(
                    "Hans",
                    "hans@web.de",
                    LocalDate.of(2000, Month.AUGUST, 14));

            Student hanna = new Student(
                    "Hanna",
                    "Hanna@web.de",
                    LocalDate.of(2001, Month.APRIL, 15));

            repository.saveAll(List.of(hans, hanna));
        };
    }
}
