package com.chanseok.shard.config;

public class UserContextHolder {
    private static final ThreadLocal<ShardKey> userContext = new ThreadLocal<>();

    public static void setSharding(String userKey) {
        getUserContext().get().setShardKey(userKey);
    }

    public static void clearSharding() {
        getUserContext().remove();
    }

    public static ThreadLocal<ShardKey> getUserContext() {
        return userContext;
    }
}
