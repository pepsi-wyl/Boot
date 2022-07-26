package com.pepsiwyl.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-03-16 20:25
 */

@Profile("dev")

@Component
@ConfigurationProperties(prefix = "person")

@Data
public class Boss implements Person{
    private String name;
    private Integer age;
}
