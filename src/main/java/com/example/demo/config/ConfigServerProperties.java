package com.example.demo.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

@RefreshScope
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "app")
public class ConfigServerProperties {

    private Service1 service1;


    @Data
    public static class Service1{

        private ServiceProps serviceProps;

    }

    @Data
    public static class ServiceProps{
        private String serviceBaseUrl;
        private int servicePort;
        private Map<String,String> endpoints;

    }
}
