package com.pepsiwyl.pojo;

import lombok.Data;
import java.util.Date;

/**
 * @author by pepsi-wyl
 * @date 2022-03-12 16:31
 */
@Data
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
