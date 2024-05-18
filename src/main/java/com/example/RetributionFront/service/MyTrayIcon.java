package com.example.RetributionFront.service;

import com.example.RetributionFront.RetributionFrontApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;

@Service
public class MyTrayIcon extends TrayIcon {

    private static final Logger log = LoggerFactory.getLogger(MyTrayIcon.class);

    static String IMAGE_PATH = "images/1.png";

    private static final String TOOLTIP = "Retribution";
    private final PopupMenu popup;
    final SystemTray tray;

    public MyTrayIcon() {
        super(Objects.requireNonNull(createImage(IMAGE_PATH, TOOLTIP)), TOOLTIP);
        this.setImageAutoSize(true);

        popup = new PopupMenu();
        tray = SystemTray.getSystemTray();

        try {
            setup();
        } catch (AWTException e) {
            log.info(e.getMessage());
        }
    }


    private void setup() throws AWTException {
        // Create a pop-up menu components
        MenuItem exitItem = new MenuItem("Exit");
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
