package com.pepsiwyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * 配置矩阵变量
 * 重新映射规则
 */
@Configuration(proxyBeanMethods = false)
public class MatrixVariableConfig implements WebMvcConfigurer {


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);   //不移除分号内容
        configurer.setUrlPathHelper(urlPathHelper);
    }


//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void configurePathMatch(PathMatchConfigurer configurer) {
//                UrlPathHelper urlPathHelper = new UrlPathHelper();
//                urlPathHelper.setRemoveSemicolonContent(false);   //不移除分号内容
//                configurer.setUrlPathHelper(urlPathHelper);
//            }
//        };
//    }
}
