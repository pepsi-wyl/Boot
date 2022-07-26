package com.pepsiwyl.Controller;

import com.pepsiwyl.pojo.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by pepsi-wyl
 * @date 2022-03-16 19:43
 */
@RestController
public class HelloController {

    @Value("${person.name:李四}")
    private String name;

    private final Person person;

    public HelloController( Person person) {
        this.person = person;
    }

    @GetMapping("/")
    public String hello() {
        return "hello  " + name + " " + person.toString();
    }

}
