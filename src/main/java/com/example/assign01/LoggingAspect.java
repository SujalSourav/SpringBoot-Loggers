package com.example.assign01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example..*(..))")
    public void appPointcut() {}

    @Before("appPointcut()")
    public void logBefore(JoinPoint joinPoint) {
    	System.out.println("🔥 AOP Triggered for: " + joinPoint.getSignature());
        logger.info("➡ Before: {}", joinPoint.getSignature());
    }

    @After("appPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("⬅ After: {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "appPointcut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        logger.info("✅ Returned from {} with value: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value = "appPointcut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.error("❌ Exception in {} with message: {}", joinPoint.getSignature(), ex.getMessage());
    }
    
}
