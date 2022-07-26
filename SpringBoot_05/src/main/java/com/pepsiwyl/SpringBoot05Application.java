package com.pepsiwyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot05Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot05Application.class, args);
        run.getBean("starterService_T", StarterService_T.class).t();
    }
}
