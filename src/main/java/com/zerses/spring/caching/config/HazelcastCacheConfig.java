package com.zerses.spring.caching.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.EntryView;
import com.hazelcast.map.eviction.MapEvictionPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HazelcastCacheConfig {

    @Bean
    public Config hazelCastConfig() {

        Config config = new Config();
        config.setInstanceName("hazelcast-cache");

        MapConfig cacheConfig1 = new MapConfig();

        cacheConfig1.setTimeToLiveSeconds(60 * 60 * 4);  //Cache for 4 hours
        cacheConfig1.setMaxIdleSeconds(60 * 30);         //Max idle for 30 minutes
        cacheConfig1.setMaxSizeConfig(new MaxSizeConfig(1, MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE)); //Max MB used

        cacheConfig1.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put("cache1", cacheConfig1);

        return config;
    }

}
