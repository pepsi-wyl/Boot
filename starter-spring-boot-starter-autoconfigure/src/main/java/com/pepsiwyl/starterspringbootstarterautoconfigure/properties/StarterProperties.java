package com.pepsiwyl.starterspringbootstarterautoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-03-17 13:13
 */

@Component
@ConfigurationProperties(prefix = "hellostarter")
public class StarterProperties {
    private String prefix;
    private String suffix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
