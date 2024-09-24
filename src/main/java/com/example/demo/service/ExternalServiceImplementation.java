package com.example.demo.service;

import com.example.demo.config.ConfigServerProperties;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class ExternalServiceImplementation {

    Logger log = LoggerFactory.getLogger(ServiceImplementation.class);
    private final WebClient webClient;
    private final ConfigServerProperties configServerProperties;
    public ExternalServiceImplementation(WebClient webClient,ConfigServerProperties configServerProperties){
        this.webClient=webClient;
        this.configServerProperties=configServerProperties;
    }

    @CircuitBreaker(name = "getUsersCircuitBreaker", fallbackMethod = "getUsersFallback")
    @Retry(name = "getUsersRetry", fallbackMethod = "getUsersFallback")
    @Bulkhead(name = "getUsersBulkHead", type = Bulkhead.Type.SEMAPHORE)
    @RateLimiter(name = "getUsersRateLimiter", fallbackMethod = "getUsersFallback")
    @TimeLimiter(name = "getUsersTimeLimiter", fallbackMethod = "getUsersFallback")
    public Mono<List<User>> getUsers() {
        return webClient.get()
                .uri(getCompleteUri("getUsers"))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<User>>() {});
    }


    @CircuitBreaker(name = "addUserCircuitBreaker", fallbackMethod = "addUserFallback")
    @Retry(name = "addUserRetry", fallbackMethod = "addUserFallback")
    @Bulkhead(name = "addUserBulkHead", type = Bulkhead.Type.SEMAPHORE)
    @RateLimiter(name = "addUserRateLimiter", fallbackMethod = "addUserFallback")
    @TimeLimiter(name = "addUserTimeLimiter", fallbackMethod = "addUserFallback")
    public Mono<List<User>> addNewUser() {
        return webClient.post()
                .uri(getCompleteUri("addNewUser"))
                .bodyValue(new User("New Name", 55, "new Gender", new Address("IN", "HD", "HD", "8888")))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<User>>() {});
    }

    @CircuitBreaker(name = "getUserCircuitBreaker", fallbackMethod = "getUserFallback")
    @Retry(name = "getUserRetry", fallbackMethod = "getUserFallback")
    @Bulkhead(name = "getUserBulkHead", type = Bulkhead.Type.SEMAPHORE)
    @RateLimiter(name = "getUserRateLimiter", fallbackMethod = "getUserFallback")
    @TimeLimiter(name = "getUserTimeLimiter", fallbackMethod = "getUserFallback")
    public Mono<User> getUser() {
        return webClient.get()
                .uri(getCompleteUri("getUser"), "Cathy")
                .retrieve()
                .bodyToMono(User.class);
    }

    @CircuitBreaker(name = "modifyUserCircuitBreaker", fallbackMethod = "modifyUserFallback")
    @Retry(name = "modifyUserRetry", fallbackMethod = "modifyUserFallback")
    @Bulkhead(name = "modifyUserBulkHead", type = Bulkhead.Type.SEMAPHORE)
    @RateLimiter(name = "modifyUserRateLimiter", fallbackMethod = "modifyUserFallback")
    @TimeLimiter(name = "modifyUserTimeLimiter", fallbackMethod = "modifyUserFallback")
    public Mono<User> modifyUser() {
        return webClient.put()
                .uri(getCompleteUri("modifyUser"))
                .bodyValue(new User("Summar", 1000, "Fairy", new Address("IN", "HD", "HD", "8888")))
                .retrieve()
                .bodyToMono(User.class);

    }


    // Fallback methods for each service call
    public Mono<List<User>> getUsersFallback(Throwable throwable) {
        log.error("-------> Fallback for getUsers {}", throwable.getMessage());
        return Mono.just(Collections.emptyList());
    }

    public Mono<List<User>> addUserFallback(Throwable throwable) {
        log.error("-------> Fallback for addNewUser {}", throwable.getMessage());
        return Mono.just(Collections.emptyList());
    }

    public Mono<User> getUserFallback(Throwable throwable) {
        log.error("-------> Fallback for getUser {}", throwable.getMessage());
        return Mono.just(new User("Fallback", 0, "Unknown", new Address("Unknown", "Unknown", "Unknown", "0000")));  // Return fallback user
    }

    public Mono<User> modifyUserFallback(Throwable throwable) {
        log.error("-------> Fallback for modifyUser  {}: ", throwable.getMessage());  // Log the actual exception
        return Mono.just(new User("Fallback", 0, "Unknown", new Address("Unknown", "Unknown", "Unknown", "0000")));  // Return fallback user
    }


    private String getCompleteUri(String getUser) {
        return configServerProperties.getService1().getServiceProps().getServiceBaseUrl() +
                configServerProperties.getService1().getServiceProps().getServicePort() +
                configServerProperties.getService1().getServiceProps().getEndpoints().get(getUser);
    }



}
