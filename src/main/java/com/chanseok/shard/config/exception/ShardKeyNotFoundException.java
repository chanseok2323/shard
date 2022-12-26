package com.chanseok.shard.config.exception;

public class ShardKeyNotFoundException extends RuntimeException {

    public ShardKeyNotFoundException() {
        super();
    }

    public ShardKeyNotFoundException(String message) {
        super(message);
    }
}
