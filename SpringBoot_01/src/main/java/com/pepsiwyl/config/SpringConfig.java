package com.pepsiwyl.config;


import com.pepsiwyl.pojo.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author by pepsi-wyl
 * @date 2022-03-06 15:43
 */

@ComponentScan("com.pepsiwyl")              // 扫描包

@EnableConfigurationProperties(Car.class)   // 开启Car的配置绑定功能 将Car组件注册到容器中

@ImportResource("classpath:test.xml")       // 导入XML配置文件
@Import({T1.class, T2.class})               // 给容器中自动创建出这个类型的组件（通常为第三方组件）  默认名称为全类名

@ConditionalOnBean(name = {"user", "pet"})  // 容器中存在 user组件 和 pet 组件的时候 给配置类生效

@Configuration(proxyBeanMethods = true)     // 配置类 full模式
public class SpringConfig {

    @Primary  //优先注入此类
    @ConditionalOnMissingBean(name = "pet")            //容器中没有pet组件的时候才装配
    @Bean      //给容器中添加组件  方法名称为组件ID   返回类型为组件类型   返回的对象为容器中的实例
    public Pet pet() {
        return new Pet("Tomcat");
    }

    @ConditionalOnMissingBean(name = "user")           //容器中有user组件的时候才装配
    @Bean      //给容器中添加组件  方法名称为组件ID  返回类型为组件类型   返回的对象为容器中的实例
    public User user() {
        return new User(1002L, "pepsi-wyl", "999999", pet());
    }

}
