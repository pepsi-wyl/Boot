package com.pepsiwyl.controller;

import com.pepsiwyl.test.BoundAPI_Test;
import com.pepsiwyl.test.RedisTemplate_Test;
import com.pepsiwyl.test.StringRedisTemplate_Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by pepsi-wyl
 * @date 2022-04-02 10:28
 */

@RestController
public class RedisController {

    private final StringRedisTemplate_Test stringRedisTemplate_test;
    private final RedisTemplate_Test redisTemplate_test;
    private final BoundAPI_Test boundAPI_test;

    public RedisController(StringRedisTemplate_Test stringRedisTemplate_test, RedisTemplate_Test redisTemplate_test, BoundAPI_Test boundAPI_test) {
        this.stringRedisTemplate_test = stringRedisTemplate_test;
        this.redisTemplate_test = redisTemplate_test;
        this.boundAPI_test = boundAPI_test;
    }

    @GetMapping("/")
    public String test() {
//        stringRedisTemplate_test.Zset_Test();
//        redisTemplate_test.test();
//        boundAPI_test.test();
        return "OK~";
    }

}
