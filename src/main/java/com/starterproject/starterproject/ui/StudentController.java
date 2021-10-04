package com.starterproject.starterproject.ui;

import com.starterproject.starterproject.student.Student;
import com.starterproject.starterproject.student.StudentService;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentController extends StudentView {

    private final StudentService studentService;
    Binder<Student> binder = new Binder<>();

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
        initBinder();

        btnSave.addClickListener(e -> saveStudent(binder.getBean()));

        btnClear.addClickListener(e -> clear());

//        studentList.setItems(studentService.getStudents());
//        studentList.addValueChangeListener(e -> binder.setBean(e.getValue()));

        userGrid.setItems(studentService.getStudents());
        userGrid.addSelectionListener(e -> binder.setBean(e.getFirstSelectedItem().orElseGet(Student::new)));

    }

    private void clear() {
        binder.setBean(new Student());
        userGrid.deselectAll();
        userGrid.setItems(studentService.getStudents());
    }

    public void saveStudent(Student student) {

        if (!binder.validate().isOk()) {
            getDefaultNotifcation("Please check your entry").open();
            return;
        }

        try {
            studentService.saveStudent(student);
        } catch (Exception e) {
            getDefaultNotifcation("Saving was canceled").open();
        }

        clear();
    }

    private void initBinder() {
        binder.forField(firstName)
                .withValidator(new EmtyObjectValidator())
                .bind(Student::getFirstName, Student::setFirstName);
        binder.forField(lastName)
                .withValidator(new EmtyObjectValidator())
                .bind(Student::getLastName, Student::setLastName);
        binder.forField(email)
                .withValidator(new EmtyObjectValidator())
                .withValidator(new EmailValidator("E-Mail is invalid."))
                .bind(Student::getEmail, Student::setEmail);
        binder.forField(dayOfBirth)
                .withValidator(new EmtyObjectValidator())
                .bind(Student::getDayOfBirth, Student::setDayOfBirth);
        binder.setBean(new Student());
    }

    private Notification getDefaultNotifcation(String message) {
        return new Notification(message, 2000, Notification.Position.TOP_START);
    }
}
