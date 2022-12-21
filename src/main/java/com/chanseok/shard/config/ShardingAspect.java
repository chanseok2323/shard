package com.chanseok.shard.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ShardingAspect {

    @Pointcut("execution(public * com.chanseok.shard.service..*.*(..))")
    private void service() {}

    @Around("service() && args(userNo, ..) && @annotation(com.chanseok.shard.config.Sharding)")
    public Object shardingAround(ProceedingJoinPoint joinPoint, String userNo) throws Throwable {
        UserContextHolder.setShard(userNo.substring(0, 1));
        Object proceed = joinPoint.proceed();
        UserContextHolder.clearShard();

        return proceed;
    }
}
