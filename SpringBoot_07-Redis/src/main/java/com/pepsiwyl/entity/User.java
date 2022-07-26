package com.pepsiwyl.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author by pepsi-wyl
 * @date 2022-07-22 9:06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
// 尽量实现JDK的序列化机制
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Date date;
}
