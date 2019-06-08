package com.zerses.spring.caching.repository;

import com.zerses.spring.caching.model.UserPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Component
public class MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    @Cacheable(cacheNames = "cache1",key = "{#key}")
    public String getV(String key) {
        LOGGER.info("Calling repo for key="+key);
        return MyRepository.getV(key);
    }
}
