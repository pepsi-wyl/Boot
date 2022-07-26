package com.pepsiwyl.starterspringbootstarterautoconfigure.auto;

import com.pepsiwyl.starterspringbootstarterautoconfigure.properties.StarterProperties;
import com.pepsiwyl.starterspringbootstarterautoconfigure.service.StarterService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by pepsi-wyl
 * @date 2022-03-17 13:17
 */

@Configuration
@ConditionalOnMissingBean(StarterService.class)
@EnableConfigurationProperties(StarterProperties.class)  // 默认放在容器中
public class StarterAutoConfiguration {
    @Bean
    public StarterService starterService() {
        return new StarterService();
    }
}
