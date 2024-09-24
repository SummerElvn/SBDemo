package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Component
public class InterceptorController implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("In Interceptor controller, preHandle"+ LocalDateTime.now()+"-->"+request.getPathInfo()
                +"-->"+request.getPathInfo()
                +"-->"+request.getContextPath()
                +"-->"+request.getAuthType()
                +"-->"+request.getRequestURI()+
                "-->"+request.getDispatcherType());
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("In Interceptor controller, postHandle"+ LocalDateTime.now());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println("In Interceptor controller, afterCompletion"+ LocalDateTime.now());
    }

}
