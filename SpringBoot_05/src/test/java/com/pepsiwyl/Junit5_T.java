package com.pepsiwyl;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author by pepsi-wyl
 * @date 2022-03-15 13:56
 */

@SpringBootTest // 引入SpringBoot环境

@DisplayName("测试类")
public class Junit5_T {


    @RepeatedTest(5)  // 重复测试 5次
    @Timeout(value = 5, unit = TimeUnit.MILLISECONDS)  // 超时时间
    @DisplayName("测试1")  //为测试类或者测试方法设置展示名称
    @Test
    public void t1() {
        System.out.println("test1");
    }

    //    @Disabled // 表示测试类或测试方法不执行
    @RepeatedTest(5)  // 重复测试 5次
    @Timeout(value = 5, unit = TimeUnit.MILLISECONDS)  // 超时时间
    @DisplayName("测试2")  //为测试类或者测试方法设置展示名称
    @Test
    public void t2() {
        System.out.println("test2");
    }

    @BeforeEach  // 表示在每个单元测试之前执行
    public void BeforeEach_T() {
        System.out.println("单元测试开始执行了......");
    }

    @AfterEach   // 表示在每个单元测试之后执行
    public void AfterEach_T() {
        System.out.println("单元测试执行完毕了......");
    }

    @BeforeAll  // 表示在所有单元测试之前执行   static方法
    public static void BeforeAll_T() {
        System.out.println("所有单元测试开始执行了......");
    }


    @AfterAll   //表示在所有单元测试之后执行    static方法
    public static void AfterAll_T() {
        System.out.println("所有单元测试执行完毕了......");
    }


}
