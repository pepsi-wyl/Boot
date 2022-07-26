package com.pepsiwyl.test;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author by pepsi-wyl
 * @date 2022-07-21 10:26
 */

@Component("stringRedisTemplate_Test")
public class StringRedisTemplate_Test {

    //注入StringRedisTemplate
    private final StringRedisTemplate stringRedisTemplate;

    public StringRedisTemplate_Test(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    // key测试
    public void key_Test() {

        // 随机获取一个key
        System.out.println(stringRedisTemplate.randomKey());

        // 得到符合条件的key
        Objects.requireNonNull(stringRedisTemplate.keys("*")).forEach(key -> System.out.println("key = " + key));

        // 为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除
        stringRedisTemplate.expire("key", 100, TimeUnit.SECONDS);

        // 获取key超时时间 -1 永不超时  -2  key不存在 >=0 过期时间
        System.out.println(stringRedisTemplate.getExpire("key"));

        // 移除给定 key 的生存时间  将这个 key 从『易失的』(带生存时间 key )转换成『持久的』(一个不带生存时间、永不过期的 key
        stringRedisTemplate.persist("key");

        // 判断某个key是否存在    true存在 false不存在
        System.out.println(stringRedisTemplate.hasKey("key"));

        // 判断key所对应值的类型  NONE 不存在
        System.out.println(stringRedisTemplate.type("key"));

        // 修改key名字
        stringRedisTemplate.rename("key", "key1");
        // 修改key名字   当且仅当 newkey 不存在时，将 key 改名为 newkey
        stringRedisTemplate.renameIfAbsent("key", "key1");

        // 移动key到指定的库       true 移动成功   false 移动失败
        stringRedisTemplate.move("key", 1);

        // 删除一个key或者多个key
        stringRedisTemplate.delete("key");
        stringRedisTemplate.delete(Arrays.asList("key", "key1"));
    }

    // String测试  opsForValue
    public void String_Test() {

        // 设置一个 key-value 对  不指定过期时间
        stringRedisTemplate.opsForValue().set("name", "武扬岚");
        // 设置一个 key-value 对  指定过期时间
        stringRedisTemplate.opsForValue().set("name", "武扬岚", 120, TimeUnit.SECONDS);

        // APPEND 命令将 value 追加到 key 原来的值的末尾
        stringRedisTemplate.opsForValue().append("name", "pepsi-wyl");

        // 同时设置一个或多个 key-value 对  必须为 String-String类型
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "pepsi-wyl");
        map.put("password", "000000");
        stringRedisTemplate.opsForValue().multiSet(map);

        // 返回 key 所关联的字符串值
        System.out.println(stringRedisTemplate.opsForValue().get("name"));

        // 返回所有(一个或多个)给定 key 的值
        List<String> keys = new ArrayList<>();
        keys.add("username");
        keys.add("password");
        Objects.requireNonNull(stringRedisTemplate.opsForValue().multiGet(keys)).forEach(System.out::println);

        // 将 key 中储存的数字值增一
        stringRedisTemplate.opsForValue().increment("number");
        // 将 key 中储存的数字值减一
        stringRedisTemplate.opsForValue().decrement("number");
    }

    // List测试    opsForList
    public void List_Test() {

        // 将一个或多个值 value 插入到列表 key 的表头
        List<String> name = new ArrayList<>();
        name.add("pepsi-wyl");
        name.add("wyl");
        stringRedisTemplate.opsForList().leftPush("name", "pepsi-wyl");
        stringRedisTemplate.opsForList().leftPushAll("name", "pepsi-wyl", "wyl");
        stringRedisTemplate.opsForList().leftPushAll("name", name);

        // 遍历List 从 start 到 end
        Objects.requireNonNull(
                stringRedisTemplate.opsForList().range("name", 0, -1)
        ).forEach(System.out::println);

        // 截取list的指定区间
        stringRedisTemplate.opsForList().trim("name", 0, -1);
    }

    // Set测试     opsForSet
    public void Set_Test() {
        // 将一个或多个 member 元素加入到集合 key 当中
        stringRedisTemplate.opsForSet().add("sets", "张三", "张三", "小陈", "xiaoming");

        // 查看set中成员
        Objects.requireNonNull(stringRedisTemplate.opsForSet().members("sets")).forEach(value -> System.out.println("value = " + value));

        // 返回集合中的一个或多个随机元素
        stringRedisTemplate.opsForSet().randomMember("sets");
        stringRedisTemplate.opsForSet().randomMembers("sets", 2);

        // 移除集合 key 中的一个或多个 member 元素
        stringRedisTemplate.opsForSet().remove("sets", "xiaoming");

        // 获取set集合元素个数
        System.out.println(stringRedisTemplate.opsForSet().size("sets"));
    }

    // Hash测试    opsForHash
    public void Hash_Test() {

        // 放入一个key value
        stringRedisTemplate.opsForHash().put("maps", "name", "张三");
        // 放入多个key value
        Map<String, String> map = new HashMap<String, String>();
        map.put("age", "12");
        map.put("bir", "2012-12-12");
        stringRedisTemplate.opsForHash().putAll("maps", map);

        // 查看哈希表 key 中，给定域 field 是否存在
        System.out.println(stringRedisTemplate.opsForHash().hasKey("maps", "name"));

        // 获取hash中某个key的值
        System.out.println(stringRedisTemplate.opsForHash().get("maps", "name"));
        // 获取多个key的value
        stringRedisTemplate.opsForHash().multiGet("maps", Arrays.asList("name", "age")).forEach(System.out::println);

        // 获取所有values
        System.out.println(stringRedisTemplate.opsForHash().values("maps"));
        // 获取所有keys
        System.out.println(stringRedisTemplate.opsForHash().keys("maps"));
        // 获取所有所有的values和keys
        System.out.println(stringRedisTemplate.opsForHash().entries("maps"));

    }

    // Zset测试     opsForZset
    public void Zset_Test() {

        // 将一个或多个 member 元素及其 score 值加入到有序集 key 当中
        stringRedisTemplate.opsForZSet().add("zsets", "小黑", 20);
        stringRedisTemplate.opsForZSet().add("zsets", "wyl", 100);

        // 移除有序集 key 中的一个或多个成员
        stringRedisTemplate.opsForZSet().remove("zsets", "小黑", "zhazha");

        // 为有序集 key 的成员 member 的 score 值加上增量 increment
        stringRedisTemplate.opsForZSet().incrementScore("zsets", "wyl", 100);

        // 返回有序集 key 对应的成员总数
        System.out.println(stringRedisTemplate.opsForZSet().zCard("zsets"));

        // 返回有序集 key 中，score 值在 min 和 max 之间成员数量
        System.out.println(stringRedisTemplate.opsForZSet().count("zsets", 10, 100));

        // 返回有序集 key 中，指定区间内的成员 正序
        Objects.requireNonNull(stringRedisTemplate.opsForZSet().range("zsets", 0, -1)).forEach(System.out::println);
        // 返回有序集 key 中，指定区间内的成员 反序
        Objects.requireNonNull(stringRedisTemplate.opsForZSet().reverseRange("zsets", 0, -1)).forEach(System.out::println);
        // 返回有序集 key 中，指定分数区间内的成员 正序
        Objects.requireNonNull(stringRedisTemplate.opsForZSet().rangeByScore("zsets", 10, 100)).forEach(System.out::println);
        // 返回有序集 key 中，指定分数区间内的成员 反序
        Objects.requireNonNull(stringRedisTemplate.opsForZSet().reverseRangeByScore("zsets", 10, 100)).forEach(System.out::println);
        // 返回有序集 key 中，指定区间内的成员 指定元素以及分数
        Objects.requireNonNull(stringRedisTemplate.opsForZSet().rangeByScoreWithScores("zsets", 0, 1000)).forEach(typedTuple -> {
            System.out.println(typedTuple.getValue());
            System.out.println(typedTuple.getScore());
        });

    }


}
