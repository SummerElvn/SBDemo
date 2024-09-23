package com.example.demo.controller;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ServletFilterHandler implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("in Filter Init Method");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Getting Host From Filter Before Controller"+request.getRemoteHost());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("in Filter destroy Method");
        Filter.super.destroy();
    }
}
