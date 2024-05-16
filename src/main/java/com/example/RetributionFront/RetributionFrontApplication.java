package com.example.RetributionFront;

import com.example.RetributionFront.web.MyTrayIcon;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RetributionFrontApplication {
    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
//		SpringApplication.run(RetributionFrontApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(RetributionFrontApplication.class);
        builder.headless(false);
        context = builder.run(args);

        MyTrayIcon m = new MyTrayIcon();
    }

}
