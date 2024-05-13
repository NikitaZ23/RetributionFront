package com.example.RetributionFront.web;//package com.example.retributionFront.web;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
@StyleSheet("styles.css")
public class MainWindow extends AppLayout {

    Button buttonTask;
    Button buttonDescription;

    public MainWindow() {
        H1 lText = new H1("Добро пожаловать на проект Возмездие!");

        buttonTask = new Button("Задачник");
        buttonDescription = new Button("Разборщик");
        buttonTask.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
                ButtonVariant.LUMO_ERROR);
        buttonDescription.addClassName("v-button-custom");
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(lText, buttonTask, buttonDescription);
        verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        verticalLayout.setSpacing(true);
        verticalLayout.setSizeFull();

        setContent(verticalLayout);
    }
}
