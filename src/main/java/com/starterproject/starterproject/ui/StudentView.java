package com.starterproject.starterproject.ui;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


public class StudentView extends BasicDataView {

    public StudentView() {
        add(new HorizontalLayout(firstName, lastName),
                new HorizontalLayout(email, dayOfBirth),
                new HorizontalLayout(btnSave,btnClear),
                userGrid);
    }
}

