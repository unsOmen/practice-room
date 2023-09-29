package com.unsomen.aspects.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AppAspect {

    @Pointcut("execution(public * com.unsomen.aspects.service.UserService.*(..))")
    public void executeUserService() { }

    @Pointcut("execution(public * com.unsomen.aspects.service.UserService.addUser(..))")
    public void executeAddUser() { }

    @Before(value = "executeUserService()")
    public void logUserServiceBefore(JoinPoint jp) {
        log.info("START UserService # {} : {}", jp.getSignature().getName(), jp.getArgs());
    }

    @After(value = "executeUserService()")
    public void logUserServiceAfter(JoinPoint jp) {
        log.info("END UserService # {} : {}", jp.getSignature().getName(), jp.getArgs());
    }

    @AfterReturning(value = "executeAddUser()", returning = "retUid")
    public void logUserServiceAddUserUid(JoinPoint jp, String retUid) {
        log.info("ADDED '{}' - {}", jp.getArgs()[0], retUid);
    }

    @Around(value = "executeAddUser()")
    public Object logUserServiceAddUserUid2(ProceedingJoinPoint pjp) {
        try {
            String userName = (String) pjp.getArgs()[0];
            if (userName.startsWith("old")) {
                String proceedObject = (String) pjp.proceed();
                log.info("Add prefix 'old': {}", proceedObject);
                return "old-" + proceedObject;
            }
            return pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
