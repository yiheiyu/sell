package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "project-url")
public class ProjectUrlConfig {

    /**
     * 点餐系统
     */
    private String sell;
}
