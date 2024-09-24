package com.example.demo.service;

import com.example.demo.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IService {
    public Mono<List<User>> getUserInfo();

}
