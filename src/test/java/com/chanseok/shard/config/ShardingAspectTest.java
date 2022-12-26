package com.chanseok.shard.config;

import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingAspectTest {

    @Autowired ShardingAspect shardingAspect;

    @Test
    void aopIsTrue() {
        System.out.println(AopUtils.isAopProxy(shardingAspect));
    }

}