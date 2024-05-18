package com.example.RetributionFront;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RetributionFrontApplication {
    public static ConfigurableApplicationContext context;

//    @Autowired
//    public static MyTrayIcon m;

    public static void main(String[] args) {
//		SpringApplication.run(RetributionFrontApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(RetributionFrontApplication.class);
        builder.headless(false);
        context = builder.run(args);
    }

}
