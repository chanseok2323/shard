package com.chanseok.shard.config.datasource;

import com.chanseok.shard.config.ShardKey;
import com.chanseok.shard.config.ShardsDatasourceProperty;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfig {

    private final ShardsDatasourceProperty shardsDatasourceProperty;

    @Bean
    public DataSource mainDataSource() {
        DataSourceRouter dataSourceRouter = new DataSourceRouter();
        Map<Object, Object> datasourceMap = new LinkedHashMap<>();
        ShardsDatasourceProperty.Shards main = shardsDatasourceProperty.getMain();

        for (int i = 0; i < main.getShards().size(); i++) {
            ShardsDatasourceProperty.DataProperty dataProperty = main.getShards().get(i);

            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl(dataProperty.getUrl());
            hikariConfig.setUsername(dataProperty.getUsername());
            hikariConfig.setPassword(dataProperty.getPassword());
            DataSource dataSource = new HikariDataSource(hikariConfig);

            datasourceMap.put(ShardKey.values()[i], dataSource);
        }

        dataSourceRouter.setTargetDataSources(datasourceMap);
        dataSourceRouter.afterPropertiesSet();

        return new LazyConnectionDataSourceProxy(dataSourceRouter);
    }
}
