package com.chanseok.shard.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ShardsDatasourceProperty {

    private List<Shard> shards;

    @Getter @Setter
    public static class Shard {
        private String url;
        private String username;
        private String password;
    }
}
