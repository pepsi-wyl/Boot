package com.pepsiwyl;

import com.pepsiwyl.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBoot01Application {
    public static void main(String[] args) {
        // 返回IOC容器实例
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot01Application.class, args);
        Person person = run.getBean("person", Person.class);
        System.out.println(person);
    }
}
