package com.starterproject.starterproject.student;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate dayOfBirth;

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, String firstName, String email, LocalDate dayOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.email = email.toLowerCase();
        this.dayOfBirth = dayOfBirth;
    }

    public Student(String firstName, String email, LocalDate dayOfBirth) {
        this.firstName = firstName;
        this.email = email.toLowerCase();
        this.dayOfBirth = dayOfBirth;
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getAge() {
        return Period.between(dayOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + email + " " + dayOfBirth + " " + age;
    }
}
