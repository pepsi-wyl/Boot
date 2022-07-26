package com.pepsiwyl.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-03-06 15:40
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Component(value = "pet")
public class Pet {
    @Value("Tomcat")
    private String name;
}
