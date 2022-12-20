package com.chanseok.shard.config.datasource;

import com.chanseok.shard.config.ShardKey;
import com.chanseok.shard.config.ShardsDatasourceProperty;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@ConstructorBinding
@Getter @Setter
@ConfigurationProperties(prefix = "datasource")
public class DatasourceConfig {
    private ShardsDatasourceProperty main;

    @Bean
    public DataSource mainDataSource() {
        DataSourceRouter dataSourceRouter = new DataSourceRouter();
        Map<Object, Object> datasourceMap = new LinkedHashMap<>();

        for (int i = 0; i < main.getShards().size(); i++) {
            ShardsDatasourceProperty.Shard shard = main.getShards().get(i);

            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl(shard.getUrl());
            hikariConfig.setUsername(shard.getUsername());
            hikariConfig.setPassword(shard.getPassword());
            DataSource dataSource = new HikariDataSource(hikariConfig);

            datasourceMap.put(ShardKey.values()[i], dataSource);
        }

        dataSourceRouter.setTargetDataSources(datasourceMap);
        dataSourceRouter.afterPropertiesSet();

        return new LazyConnectionDataSourceProxy(dataSourceRouter);
    }
}
