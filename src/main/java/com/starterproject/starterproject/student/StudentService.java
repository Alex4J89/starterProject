package com.starterproject.starterproject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student)
    {
        if(student.getId() == null) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

            if(studentOptional.isPresent()) {
                throw new IllegalStateException("E-Mail already exist");
            }
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id))
        {
            throw new IllegalStateException("the student with the " + id + "does not exist!");
        }

        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Student student)
    {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());

        if(optionalStudent.isEmpty())
        {
            throw new IllegalStateException("Student with ID " + student.getId() + " does not exist!");
        }

        Student originStudent = optionalStudent.get();

        originStudent.setFirstName(student.getFirstName());
        originStudent.setLastName(student.getLastName());
        originStudent.setEmail(student.getEmail());
        originStudent.setDayOfBirth(student.getDayOfBirth());

        studentRepository.save(originStudent);
    }
}
