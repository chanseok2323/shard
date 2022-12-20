package com.chanseok.shard.config.datasource;

import com.chanseok.shard.config.ShardKey;
import com.chanseok.shard.config.UserContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return UserContextHolder.getShardKey() == null ? ShardKey.MAIN_01 : UserContextHolder.getShardKey();
    }
}
