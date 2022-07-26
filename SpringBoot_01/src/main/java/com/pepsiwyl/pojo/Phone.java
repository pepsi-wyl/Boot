package com.pepsiwyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-03-07 21:25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@ConfigurationProperties(prefix = "phone")  // 与phone前缀绑定
@Component(value = "phone")                 // 将phone组件放入容器
public class Phone {
    private String phoneName;
}
