package com.chanseok.shard.config.datasource;

import com.chanseok.shard.config.ShardsDatasourceProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConstructorBinding
@ConfigurationProperties(prefix = "datasource")
public class DatasourceConfig {
    private ShardsDatasourceProperty main;
}
