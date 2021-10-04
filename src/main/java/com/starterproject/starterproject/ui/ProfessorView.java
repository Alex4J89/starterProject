package com.starterproject.starterproject.ui;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class ProfessorView extends BasicDataView{

    ComboBox<String> subjectArea = new ComboBox<>("Subject Area");
    TextField title = new TextField("Title");

    public ProfessorView() {
        add(new HorizontalLayout(title, firstName, lastName),
                new HorizontalLayout(email, dayOfBirth, subjectArea),
                new HorizontalLayout(btnSave,btnClear),
                userGrid);
    }
}
