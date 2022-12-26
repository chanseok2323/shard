package com.chanseok.shard.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public class UserContextHolder {
    private static final ThreadLocal<ShardKey> userContext = new ThreadLocal<>();

    public static void setShard(String userKey) {
        Assert.notNull(userKey, "user key cannot be null");
        ShardKey shardKey = ShardKey.setShardKey(userKey);
        log.info("shardkey = {}", shardKey);
        userContext.set(shardKey);
    }

    public static void clearShard() {
        getUserContext().remove();
    }

    private static ThreadLocal<ShardKey> getUserContext() {
        return userContext;
    }

    public static ShardKey getShardKey() {
        return getUserContext().get();
    }
}
