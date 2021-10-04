package com.starterproject.starterproject.ui;

import com.starterproject.starterproject.student.Student;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public abstract class BasicDataView extends VerticalLayout {

    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last Name");
    TextField email = new TextField("E-Mail");
    DatePicker dayOfBirth = new DatePicker("Birthdate");
    Button btnSave = new Button("Save");
    Button btnClear = new Button("Clear");

    Grid<Student> userGrid = new Grid<>();


    public BasicDataView() {
        userGrid.addColumn(Student::getFirstName).setHeader("First Name");
        userGrid.addColumn(Student::getLastName).setHeader("Last Name");
        userGrid.addColumn(Student::getEmail).setHeader("E-Mail");
        userGrid.addColumn(Student::getDayOfBirth).setHeader("Day of Birth");

        firstName.setRequired(true);
        lastName.setRequired(true);
        email.setRequired(true);
        dayOfBirth.setRequired(true);
    }
}
