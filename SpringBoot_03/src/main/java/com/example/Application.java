package com.example;

import com.example.service.mailService.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
//        MailService service = run.getBean("mailService", MailService.class);
//        String[] str = {"C:\\Users\\Lenovo\\Desktop\\82953346.jpg"};
//        System.out.println(service.sendMail("2322535585@qq.com", "title", "Test", true, str));
    }

}
