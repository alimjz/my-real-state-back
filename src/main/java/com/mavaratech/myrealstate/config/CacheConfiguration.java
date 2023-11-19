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
    public Cache<String, List<ShareEntity>> shareFromCache(
            @Qualifier("loaderCacheFrom") CacheLoader<String, List<ShareEntity>> loaderCacheFrom) {
        return CacheBuilder.newBuilder()
                .refreshAfterWrite(Duration.ofSeconds(60))
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build(loaderCacheFrom);
    }

    @Bean("shareToCache")
    public Cache<String, List<ShareEntity>> shareToCache(
            @Qualifier("loaderCacheTo") CacheLoader<String, List<ShareEntity>> loaderCacheTo) {
        return CacheBuilder.newBuilder()
                .refreshAfterWrite(Duration.ofSeconds(60))
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build(loaderCacheTo);
    }

    @Bean("loaderCacheFrom")
    CacheLoader<String, List<ShareEntity>> loaderCacheFrom(ShareEstateRepository repository) {
        return new CacheLoader<>() {
            @Override
            public List<ShareEntity> load(String key) throws Exception {
                return repository.findAllByShareFrom(key);
            }
        };
    }

    @Bean("loaderCacheTo")
    CacheLoader<String, List<ShareEntity>> loaderCacheTo(ShareEstateRepository repository) {
        return new CacheLoader<>() {
            @Override
            public List<ShareEntity> load(String key) throws Exception {
                return repository.findAllByShareTo(key);
            }
        };
    }
}
