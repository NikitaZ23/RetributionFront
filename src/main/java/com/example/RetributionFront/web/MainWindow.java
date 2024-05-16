package com.example.RetributionFront.web;//package com.example.retributionFront.web;

import com.vaadin.flow.component.UI;
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
//        getElement().getStyle().set("background-image", "url(img/1.jpeg)");
        H1 lText = new H1("Добро пожаловать на проект Возмездие!");

        buttonTask = new Button("Задачник");
        buttonTask.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        buttonTask.addClickListener(event -> UI.getCurrent().navigate(TaskWindow.class));

        buttonDescription = new Button("Разборщик");
        buttonDescription.addClassName("v-button-custom");
        buttonDescription.addClickListener(event -> UI.getCurrent().navigate(DescriptionWindow.class));

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(lText, buttonTask, buttonDescription);
        verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        verticalLayout.setSpacing(true);
        verticalLayout.setSizeFull();

        setContent(verticalLayout);
    }
}
