package com.example.RetributionFront.web;

import com.example.RetributionFront.RetributionFrontApplication;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;

public class MyTrayIcon extends TrayIcon {
    static String IMAGE_PATH = "images/5.png";

    private static final String TOOLTIP = "Retribution";
    private PopupMenu popup;
    final SystemTray tray;

    public MyTrayIcon() {
        super(Objects.requireNonNull(createImage(IMAGE_PATH, TOOLTIP)), TOOLTIP);
        this.setImageAutoSize(true);
//        this.setImage(createImage("images/3.png", TOOLTIP));
        popup = new PopupMenu();
        tray = SystemTray.getSystemTray();

        try {
            setup();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


//    @PostConstruct
    private void setup() throws AWTException {
        // Create a pop-up menu components
        MenuItem exitItem = new MenuItem("Exit2");
        popup.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final int exitCode = 0;
                ExitCodeGenerator exitCodeGenerator = () -> exitCode;

                tray.remove(MyTrayIcon.this);
                SpringApplication.exit(RetributionFrontApplication.context, exitCodeGenerator);
            }
        });
        // popup.addSeparator();
        setPopupMenu(popup);
        tray.add(this);
    }

    protected static Image createImage(String path, String description) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL imageURL = classloader.getResource(path);

        if (imageURL == null) {
            System.err.println("Failed Creating Image. Resource not found: " + path);
            return null;
        } else {
            return new ImageIcon(imageURL, description).getImage();
        }
    }
}
