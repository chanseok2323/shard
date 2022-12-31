package com.chanseok.shard.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;


@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "datasource")
public class ShardsDatasourceProperty {

    private final Shards main;

    @Getter
    @ConstructorBinding
    @RequiredArgsConstructor
    public static class Shards {
        private final List<DataProperty> shards;
    }

    @Getter
    @ConstructorBinding
    @RequiredArgsConstructor
    public static class DataProperty {
        private final String url;
        private final String username;
        private final String password;
    }
}
