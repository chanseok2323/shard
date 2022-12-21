package com.chanseok.shard.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;


@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "datasource")
public class ShardsDatasourceProperty {

    private final Shards main;

    @Getter @Setter
    public static class Shards {
        private List<DataProperty> shards;
    }

    @Getter @Setter
    public static class DataProperty {
        private String url;
        private String username;
        private String password;
    }
}
