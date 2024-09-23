package com.example.demo.config;


import lombok.Data;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@Data
@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "props")
public class ConfigurationProperties {

    private String name;
    private int age;
    private String email;
}
