package com.example.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@Data
@ConfigurationProperties
public class ConfigServerProperties {

    private String url;
    private int port;
    private String name;
}
