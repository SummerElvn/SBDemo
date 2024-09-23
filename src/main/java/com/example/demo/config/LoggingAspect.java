/*
package com.example.demo.config;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut that matches all methods in services, components, and controllers
    @Pointcut("within(@org.springframework.stereotype.Service *) || within(@org.springframework.web.bind.annotation.RestController *)")
    public void applicationPackagePointcut() {
        // Pointcut for methods in @Service, @Component, @RestController, and @Controller
    }

    // Before advice to log method entry
    @Before("applicationPackagePointcut()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Entering method: {}.{}", className, methodName);
    }

    // AfterReturning advice to log method exit
    @AfterReturning("applicationPackagePointcut()")
    public void logMethodExit(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Exiting method: {}.{}", className, methodName);
    }
}
*/
