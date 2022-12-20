package com.chanseok.shard.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ShardKeyTest {

    @Test
    void getShardKey() {
        ShardKey shardKey = ShardKey.setShardKey("1");
        Assertions.assertThat(shardKey).isEqualTo(ShardKey.MAIN_01);
    }

    @Test
    void notExistShardKey() {
        Assertions.assertThatThrownBy(() -> ShardKey.setShardKey("11"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}