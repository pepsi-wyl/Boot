package com.pepsiwyl.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author by pepsi-wyl
 * @date 2022-03-06 15:37
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Component(value = "user")
public class User {

    @Value("1001")
    private Long id;

    @Value("pepsi-wyl")
    private String userNme;

    @Value("999999")
    private String password;

    @Resource(name = "pet")
    private Pet pet;

}
