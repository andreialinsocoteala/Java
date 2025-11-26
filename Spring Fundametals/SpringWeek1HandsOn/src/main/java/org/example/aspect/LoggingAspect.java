package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.service.*.*(..))")
    public void logBefore(JoinPoint jp) {
        System.out.println("[LOG] Before method: " + jp.getSignature());
    }

    @AfterReturning(pointcut = "execution(* org.example.service.*.*(..))",
            returning = "result")
    public void logAfter(JoinPoint jp, Object result) {
        System.out.println("[LOG] After method: " + jp.getSignature()
                + ", returned=" + result);
    }
}