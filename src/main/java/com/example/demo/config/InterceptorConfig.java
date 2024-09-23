package com.example.demo.config;

import com.example.demo.controller.InterceptorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    InterceptorController interceptorController;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorController);
    }
}