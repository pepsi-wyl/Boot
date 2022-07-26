package com.pepsiwyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author by pepsi-wyl
 * @date 2022-03-07 21:23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@ConfigurationProperties(prefix = "person")  // 与person前缀绑定
@Component(value = "person")                 // 将person组件放入容器
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Phone phone;
    private String[] interests;
    private List<String> animal;
    private Set<Double> salarys;
    private Map<String, Object> score;
    private Map<String, List<Phone>> allPhone;
}
