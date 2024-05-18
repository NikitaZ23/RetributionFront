package com.example.RetributionFront.web;

import com.example.RetributionFront.service.MyTrayIcon;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.Route;

@Route("description")
//@StyleSheet("styles2.css")
public class DescriptionWindow extends AppLayout {

    final MyTrayIcon icon;

    public DescriptionWindow(MyTrayIcon icon) {
//        icon.setImage(MyTrayIcon.createImage("images/7.png", "Message"));
        getElement().getStyle().clear();

        Button buttonTask = new Button("xer");

        buttonTask.addClickListener(event -> UI.getCurrent().navigate(MainWindow.class));
        setContent(buttonTask);
        this.icon = icon;
    }

}
