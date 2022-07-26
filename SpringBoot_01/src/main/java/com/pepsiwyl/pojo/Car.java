package com.pepsiwyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-03-06 18:49
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Component(value = "car")   // 必须注册组件
@ConfigurationProperties(prefix = "car")  // application.properties 配置文件中的前缀
public class Car {
    private String brand;
    private Integer price;
}
