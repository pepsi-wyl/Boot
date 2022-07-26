package com.pepsiwyl.test;

import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author by pepsi-wyl
 * @date 2022-07-22 10:24
 */

@Component("boundAPI_Test")
public class BoundAPI_Test {

    // 注入RedisTemplate
    private final RedisTemplate<String, Object> redisTemplate;
    //注入StringRedisTemplate
    private final StringRedisTemplate stringRedisTemplate;

    public BoundAPI_Test(RedisTemplate<String, Object> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void test() {

        // 针对于同一个key多次操作可以使用boundXXxOps() Value List Set Zset Hash的api 简化书写
        BoundListOperations<String, Object> lists = redisTemplate.boundListOps("lists");
        lists.leftPushAll("wyl", "zhazha", "pepsi-wyl");
        Objects.requireNonNull(lists.range(0, -1)).forEach(System.out::println);

//        stringRedisTemplate.boundValueOps()
//        stringRedisTemplate.boundListOps()
//        stringRedisTemplate.boundSetOps()
//        stringRedisTemplate.boundHashOps()
//        stringRedisTemplate.boundZSetOps()

//        redisTemplate.boundValueOps()
//        redisTemplate.boundListOps()
//        redisTemplate.boundSetOps()
//        redisTemplate.boundHashOps()
//        redisTemplate.boundZSetOps()

    }
}
