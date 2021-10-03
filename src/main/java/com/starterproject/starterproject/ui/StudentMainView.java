package com.starterproject.starterproject.ui;

import com.starterproject.starterproject.student.Student;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;



public class StudentMainView extends VerticalLayout {

    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last Name");
    TextField email = new TextField("E-Mail");
    DatePicker dayOfBirth = new DatePicker("Birthdate");
    Button btnSave = new Button("Save");
    Button btnClear = new Button("Clear");
    ListBox<Student> studentList = new ListBox<>();
    Grid<Student> studentGrid = new Grid<>();

    public StudentMainView() {
        firstName.setRequired(true);
        lastName.setRequired(true);
        email.setRequired(true);
        dayOfBirth.setRequired(true);

        studentGrid.addColumn(Student::getFirstName).setHeader("First Name");
        studentGrid.addColumn(Student::getLastName).setHeader("Last Name");
        studentGrid.addColumn(Student::getEmail).setHeader("E-Mail");
        studentGrid.addColumn(Student::getDayOfBirth).setHeader("Day of Birth");

//        studentGrid.setMultiSort(true);

        add(new HorizontalLayout(firstName, lastName),
                new HorizontalLayout(email, dayOfBirth),
                new HorizontalLayout(btnSave,btnClear),
                studentGrid);
    }
}

