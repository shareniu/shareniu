package com.shareniu.common.redis;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zyw
 * @version 1.0
 * @since 1.0 Created by zyw on 2/8/2015.
 */
public class RedisCacheManager extends AbstractCacheManager {

    private static final Logger logger = LoggerFactory
            .getLogger(RedisCacheManager.class);

    private String keyPrefix = "shiro_redis_cache:";

    private RedisManager redisManager;

    private int expire;


    /**
     * Creates a new {@code Cache} instance associated with the specified {@code name}.
     *
     * @param name the name of the cache to create
     * @return a new {@code Cache} instance associated with the specified {@code name}.
     * @throws CacheException if the {@code Cache} instance cannot be created.
     */
    @Override
    protected Cache createCache(String name) throws CacheException {
        logger.debug("create cache of name = {}", name);
        return new RedisCache(redisManager, expire, keyPrefix);
    }

    /**
     * Gets keyPrefix.
     *
     * @return Value of keyPrefix.
     */
    public String getKeyPrefix() {
        return keyPrefix;
    }

    /**
     * Gets redisManager.
     *
     * @return Value of redisManager.
     */
    public RedisManager getRedisManager() {
        return redisManager;
    }

    /**
     * Sets new keyPrefix.
     *
     * @param keyPrefix New value of keyPrefix.
     */
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    /**
     * Sets new redisManager.
     *
     * @param redisManager New value of redisManager.
     */
    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

    /**
     * Gets expire.
     *
     * @return Value of expire.
     */
    public int getExpire() {
        return expire;
    }

    /**
     * Sets new expire.
     *
     * @param expire New value of expire.
     */
    public void setExpire(int expire) {
        this.expire = expire;
    }
}
