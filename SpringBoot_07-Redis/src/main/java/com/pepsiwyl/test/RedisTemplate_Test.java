package com.pepsiwyl.test;

import com.pepsiwyl.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @author by pepsi-wyl
 * @date 2022-07-22 9:12
 */

@Component("redisTemplate_Test")
public class RedisTemplate_Test {

    // 注入RedisTemplate
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisTemplate_Test(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void test() {
        User user = new User().setId(1).setName("pepsi-wyl").setAge(21).setDate(new Date());

        // String
        redisTemplate.opsForValue().set("string", user);
        System.out.println(Objects.requireNonNull(redisTemplate.opsForValue().get("string")));

        // List
        redisTemplate.opsForList().leftPush("list", user);
        Objects.requireNonNull(redisTemplate.opsForList().range("list", 0, -1)).forEach(System.out::println);

        // Set
        redisTemplate.opsForSet().add("set", user);
        Objects.requireNonNull(redisTemplate.opsForSet().members("set")).forEach(System.out::println);

        // Hash
        redisTemplate.opsForHash().put("map", "user", user);
        System.out.println(Objects.requireNonNull(redisTemplate.opsForHash().get("map", "user")));

        // ZSet
        redisTemplate.opsForZSet().add("zset", user, 100);
        Objects.requireNonNull(redisTemplate.opsForZSet().range("zset", 0, -1)).forEach(System.out::println);

    }


}
