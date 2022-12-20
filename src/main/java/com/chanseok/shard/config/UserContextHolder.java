package com.chanseok.shard.config;

public class UserContextHolder {
    private static final ThreadLocal<ShardKey> userContext = new ThreadLocal<>();

    public static void setSharding(String userKey) {
        getShardKey().setShardKey(userKey);
    }

    public static void clearSharding() {
        getUserContext().remove();
    }

    private static ThreadLocal<ShardKey> getUserContext() {
        return userContext;
    }

    public static ShardKey getShardKey() {
        return getUserContext().get();
    }
}
