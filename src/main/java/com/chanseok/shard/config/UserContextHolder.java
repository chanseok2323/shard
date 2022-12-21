package com.chanseok.shard.config;

import org.springframework.util.Assert;

public class UserContextHolder {
    private static final ThreadLocal<ShardKey> userContext = new ThreadLocal<>();

    public static void setShard(String userKey) {
        Assert.notNull(userKey, "user key cannot be null");
        ShardKey shardKey = ShardKey.setShardKey(userKey);
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
