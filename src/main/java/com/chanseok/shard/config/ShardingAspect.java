package com.chanseok.shard.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class  ShardingAspect {

    @Pointcut("execution(public * com.chanseok.shard.service..*.*(..))")
    private void service() {}

    @Around("service() && args(userNo, ..) && @within(com.chanseok.shard.config.Sharding)")
    public Object shardingAround(ProceedingJoinPoint joinPoint, String userNo) throws Throwable {
        log.info("shard key = {}", userNo);
        UserContextHolder.setShard(userNo.substring(0, 1));
        Object proceed = joinPoint.proceed();
        UserContextHolder.clearShard();

        return proceed;
    }
}
