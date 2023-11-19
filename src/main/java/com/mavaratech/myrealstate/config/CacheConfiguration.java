package com.mavaratech.myrealstate.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.mavaratech.myrealstate.model.share.ShareEntity;
import com.mavaratech.myrealstate.repository.ShareEstateRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    @Bean("shareFromCache")
    public Cache<String, List<ShareEntity>> shareFromCache() {
        return CacheBuilder.newBuilder()
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build();
    }

    @Bean("shareToCache")
    public Cache<String, List<ShareEntity>> shareToCache() {
        return CacheBuilder.newBuilder()
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build();
    }


}
