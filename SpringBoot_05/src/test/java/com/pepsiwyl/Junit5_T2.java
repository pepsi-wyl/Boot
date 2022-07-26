package com.pepsiwyl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author by pepsi-wyl
 * @date 2022-03-15 16:25
 */

@SpringBootTest
public class Junit5_T2 {


    @DisplayName("简单断言")
    @Test
    public void simple() {

        assertEquals(3, 1 + 2, "计算结果正确");
        assertNotEquals(3, 1 + 1, "计算结果不同");

        assertNotSame(new Object(), new Object(), "对象不同");
        Object obj = new Object();
        assertSame(obj, obj, "对象相同");

        assertFalse(1 > 2);
        assertTrue(1 < 2);

        assertNull(null);
        assertNotNull(new Object());

    }

    @DisplayName("数组断言")
    @Test
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }

    @DisplayName("组合断言")
    @Test
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @DisplayName("异常断言")
    @Test
    public void exception() {
        assertThrows(ArithmeticException.class, () -> System.out.println(1 % 0));
    }


    @DisplayName("超时断言")
    @Test
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }


    @DisplayName("快速失败断言")
    @Test
    public void shouldFail() {
        fail("This should fail");
    }

}
