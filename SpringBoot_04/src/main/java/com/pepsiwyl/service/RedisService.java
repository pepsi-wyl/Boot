package com.pepsiwyl.service;

import org.springframework.stereotype.Service;

/**
 * @author by pepsi-wyl
 * @date 2022-03-15 9:27
 */

public interface RedisService {

    /**
     * 加入元素
     */
    void setValue(String key, String value);

    /**
     * 获取元素
     */
    Object getValue(String key);

}
