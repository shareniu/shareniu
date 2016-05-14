package com.shareniu.common.redis;

import com.shareniu.common.utils.SerializeUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zyw
 * @version 1.0
 * @since 1.0 Created by zyw on 2/8/2015.
 */
public class RedisCache<K, V> implements Cache<K, V> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * redis 操作对象
     */
    private RedisManager redisManager;

    /**
     * 过期时间，秒，设置次值的时候请使用毫秒
     */
    private int expire = 0;

    public RedisCache() {
    }

    public RedisCache(RedisManager redisManager, int expire, String keyPrefix) {
        this.redisManager = redisManager;
        this.keyPrefix = keyPrefix;
        this.expire = expire / 1000;
    }

    /**
     * The Redis key prefix for the sessions
     */
    private String keyPrefix = "shiro_redis_session:";

    private Charset charset = Charset.forName("utf-8");

    private byte[] getByteKey(K key) {
        if (key instanceof String) {
            return (this.keyPrefix + key).getBytes(charset);
        }

        throw new IllegalArgumentException("不支持的key类型");
    }

    /**
     * Returns the Cached value stored under the specified {@code key} or
     * {@code null} if there is no Cache entry for that {@code key}.
     *
     * @param key the key that the value was previous added with
     * @return the cached object or {@code null} if there is no entry for the specified {@code key}
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) throws CacheException {
        logger.debug("根据key从Redis中获取对象 key [" + key + "]");
        try {
            if (key == null) {
                return null;
            } else {
                byte[] rawValue = redisManager.get(getByteKey(key));
                return (V) SerializeUtils.deserialize(rawValue);
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * Adds a Cache entry.
     *
     * @param key   the key used to identify the object being stored.
     * @param value the value to be stored in the cache.
     * @return the previous value associated with the given {@code key} or {@code null} if there was previous value
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    @Override
    public V put(K key, V value) throws CacheException {
        logger.debug("根据key从存储 key [" + key + "]");
        try {
            redisManager.set(getByteKey(key), SerializeUtils.serialize(value), this.expire);
            return value;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * Remove the cache entry corresponding to the specified key.
     *
     * @param key the key of the entry to be removed.
     * @return the previous value associated with the given {@code key} or {@code null} if there was previous value
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    @Override
    public V remove(K key) throws CacheException {
        logger.debug("从redis中删除 key [" + key + "]");
        try {
            V previous = get(key);
            redisManager.del(getByteKey(key));
            return previous;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * Clear all entries from the cache.
     *
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    @Override
    public void clear() throws CacheException {
        logger.debug("从redis中删除所有元素");
        try {
            redisManager.flushDb(this.keyPrefix.getBytes(charset));
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * Returns the number of entries in the cache.
     *
     * @return the number of entries in the cache.
     */
    @Override
    public int size() {
        try {
            Long longSize = redisManager.dbSize(this.keyPrefix.getBytes(charset));
            return longSize.intValue();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * Returns a view of all the keys for entries contained in this cache.
     *
     * @return a view of all the keys for entries contained in this cache.
     */
    @Override
    public Set<K> keys() {
        try {
            Set<byte[]> keys = redisManager.keys(this.keyPrefix.getBytes(charset));
            if (keys == null || keys.isEmpty()) {
                return Collections.emptySet();
            }

            Set<K> kSet = new HashSet<K>();
            for (byte[] key : keys) {
                kSet.add((K) key);
            }

            return kSet;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * Returns a view of all of the values contained in this cache.
     *
     * @return a view of all of the values contained in this cache.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<V> values() {
        try {
            Set<byte[]> values = redisManager.values(this.keyPrefix.getBytes(charset));
            if (values == null || values.isEmpty()) {
                return Collections.emptySet();
            }

            List<V> list = new ArrayList<V>(values.size());
            V v;
            for (byte[] value : values) {
                v = (V) SerializeUtils.deserialize(value);
                list.add(v);
            }

            return list;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    /**
     * Sets new redis 操作对象.
     *
     * @param redisManager New value of redis 操作对象.
     */
    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

    /**
     * Gets redis 操作对象.
     *
     * @return Value of redis 操作对象.
     */
    public RedisManager getRedisManager() {
        return redisManager;
    }

    /**
     * Gets The Redis key prefix for the sessions.
     *
     * @return Value of The Redis key prefix for the sessions.
     */
    public String getKeyPrefix() {
        return keyPrefix;
    }

    /**
     * Sets new The Redis key prefix for the sessions.
     *
     * @param keyPrefix New value of The Redis key prefix for the sessions.
     */
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    /**
     * Sets new expire.
     *
     * @param expire New value of expire.
     */
    public void setExpire(int expire) {
        if (expire > 0) {
            this.expire = expire / 1000;
        }
    }

    /**
     * Gets expire.
     *
     * @return Value of expire.
     */
    public int getExpire() {
        return expire * 1000;
    }
}
