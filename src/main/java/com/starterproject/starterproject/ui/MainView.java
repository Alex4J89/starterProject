package com.starterproject.starterproject.ui;

import com.starterproject.starterproject.student.StudentService;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Route("")
public class MainView extends AppLayout {

    Tab tabStudent = new Tab("Students");
    Div pageStudent = new Div();
    Tab tabProfessors = new Tab("Professors");
    Div pageProfessors = new Div();

    private final StudentService studentService;

    @Autowired
    public MainView(StudentService studentService) {
        this.studentService = studentService;

        setPrimarySection(AppLayout.Section.DRAWER);

        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("44px");
        addToNavbar(new DrawerToggle(), img);

        Tab studentTab = new Tab("Students");
        Tab professorTab = new Tab("Proferssors");
        Tabs tabs = new Tabs(studentTab, professorTab);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);

        StudentController studentController = new StudentController(studentService);
        ProfessorView professorView = new ProfessorView();

        Map<Tab, Component> tabToView = new HashMap<>();
        tabToView.put(studentTab, studentController);
        tabToView.put(professorTab, professorView);

        tabs.addSelectedChangeListener(e -> setContent(tabToView.get(e.getSelectedTab())));

        setContent(studentController);

//        pageProfessors.setVisible(false);
//
//        pageStudent.add(new StudentController(studentService));
//        pageProfessors.add(new ProfessorView());
//
//        pageStudent.
//
//        Map<Tab, Component> tabsToPages = new HashMap<>();
//        tabsToPages.put(tabStudent, pageStudent);
//        tabsToPages.put(tabProfessors, pageProfessors);
//        Tabs tabs = new Tabs(tabStudent, tabProfessors);
//        Div pages = new Div(pageStudent, pageProfessors);
//
//        tabs.addSelectedChangeListener(event -> {
//            tabsToPages.values().forEach(page -> page.setVisible(false));
//            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
//            selectedPage.setVisible(true);
//        });
//
//        add(tabs, pages);
    }
}
