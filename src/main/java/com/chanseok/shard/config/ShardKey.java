package com.chanseok.shard.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShardKey {
    MAIN_00("0"), MAIN_01("1"), MAIN_02("2"), MAIN_03("3"), MAIN_04("4"),
    MAIN_05("5"), MAIN_06("6"), MAIN0_7("7"), MAIN_08("8"), MAIN_09("9");
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
