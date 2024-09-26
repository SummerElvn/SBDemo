package com.example.demo.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RefreshScope
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "app")
public class ConfigServerProperties {

    private Service1 service1;
    private String name;              // String
    private boolean enabled;          // Boolean
    private int maxUsers;             // Integer
    private double interestRate;      // Float
    private LocalDate createdOn;           // Date
    private LocalDateTime lastLogin;           // Timestamp
    private List<String> colors;      // List
    private List<Server> servers;     // List of Objects
    private Map<String, String> database; // Map (Object)
    private Object cache;             // Null (can be Object or Optional)
    private String literalBlock;      // Literal block
    private String foldedBlock;       // Folded block
    private DefaultSettings defaultSettings; // Anchor (custom object)
    private DefaultSettings customSettings;  // Alias
    @Data
    public static class Server {
        private String name;
        private String ip;

        // Getters and setters
    }

    @Data
    public static class DefaultSettings {
        private int retries;
        private int timeout;

        // Getters and setters
    }

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
