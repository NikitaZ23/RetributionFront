package com.example.RetributionFront.web;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.router.Route;

@Route("description")
@StyleSheet("styles2.css")
public class DescriptionWindow extends AppLayout {
    public DescriptionWindow() {
        getElement().getStyle().clear();

        Button buttonTask = new Button("xer");

        buttonTask.addClickListener(event -> UI.getCurrent().navigate(MainWindow.class));
        setContent(buttonTask);
    }

}
