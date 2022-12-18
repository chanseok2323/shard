package com.chanseok.shard.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ShardKeyTest {

    @Test
    void getShardKey() {
        ShardKey shardKey = ShardKey.getShardKey("1");
        Assertions.assertThat(shardKey).isEqualTo(ShardKey.MAIN01);
    }

    @Test
    void notExistShardKey() {
        Assertions.assertThatThrownBy(() -> ShardKey.getShardKey("11"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}