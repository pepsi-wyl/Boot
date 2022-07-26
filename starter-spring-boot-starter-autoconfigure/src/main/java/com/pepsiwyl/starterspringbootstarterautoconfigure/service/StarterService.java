package com.pepsiwyl.starterspringbootstarterautoconfigure.service;

import com.pepsiwyl.starterspringbootstarterautoconfigure.properties.StarterProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author by pepsi-wyl
 * @date 2022-03-17 13:11
 */

// 不放在容器中
public class StarterService {
    @Autowired
    StarterProperties starterProperties;

    public String Starter(String name) {
        return starterProperties.getPrefix() + "Starter" + name + starterProperties.getSuffix();
    }
}
