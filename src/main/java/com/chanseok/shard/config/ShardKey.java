package com.chanseok.shard.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShardKey {
    MAIN00("0"), MAIN01("1"), MAIN02("2"), MAIN03("3"), MAIN04("4"), MAIN05("5"), MAIN06("6"), MAIN07("7"), MAIN08("8"), MAIN09("9");
    private String userKey;

    public static ShardKey setShardKey(String userKey) {
        for (ShardKey key : ShardKey.values()) {
            if(key.getUserKey().equals(userKey)) {
                return key;
            }
        }
        throw new IllegalArgumentException("no search shard key");
    }
}
