package com.shareniu.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zyw
 * @version 1.0
 * @since 1.0 Created by zyw on 2/8/2015.
 */
public class DefaultRedisManager implements RedisManager {

    /**
     * jedis对象池
     */
    private Pool<Jedis> pool;

    private Jedis getJedis() {
        return pool.getResource();
    }

    private void freeJedis(Jedis jedis) {
        if (jedis != null) {
            pool.returnResource(jedis);
        }
    }

    @Override
    public byte[] get(byte[] key) {
        Jedis jedis = null;
        byte[] value = null;
        try {
            jedis = getJedis();
            value = jedis.get(key);
        } finally {
            freeJedis(jedis);
        }
        return value;
    }

    @Override
    public byte[] set(byte[] key, byte[] value) {
        return set(key, value, 0);
    }

    @Override
    public byte[] set(byte[] key, byte[] value, int expire) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
            if (expire > 0) {
                jedis.expire(key, expire);
            }
        } finally {
            freeJedis(jedis);
        }

        return value;
    }

    @Override
    public void del(byte[] key) {
        Jedis jedis = getJedis();
        try {
            jedis.del(key);
        } finally {
            freeJedis(jedis);
        }
    }

    @Override
    public void flushDb(byte[] pattern) {
        Jedis jedis = getJedis();
        try{
            Set<byte[]> keys = jedis.keys(pattern);
            if (keys != null && !keys.isEmpty()) {
                int step = 1000;
                byte[][] k = new byte[step][];
                int i = 0;
                for (byte[] key : keys) {
                    if (i%step == 0) {
                        jedis.del(k);
                        i = 0;
                    }
                    k[i] = key;
                    i++;
                }
            }
        }finally{
            freeJedis(jedis);
        }
    }

    @Override
    public Long dbSize(byte[] pattern) {
        Jedis jedis = getJedis();
        long size = 0;
        try {
            Set<byte[]> keys = jedis.keys(pattern);
            size = keys.size();
        } finally {
            freeJedis(jedis);
        }

        return size;
    }

    @Override
    public Set<byte[]> keys(byte[] pattern) {
        Set<byte[]> keys = null;
        Jedis jedis = getJedis();
        try {
            keys = jedis.keys(pattern);
        } finally {
            freeJedis(jedis);
        }
        return keys;
    }

    @Override
    public Set<byte[]> values(byte[] pattern) {
        Jedis jedis = getJedis();
        Set<byte[]> values = null;
        try {
            Set<byte[]> keys = jedis.keys(pattern);
            if (keys != null && !keys.isEmpty()) {
                values = new HashSet<byte[]>();
                for (byte[] key : keys) {
                    values.add(jedis.get(key));
                }
            }

        } finally {
            freeJedis(jedis);
        }
        return values;
    }

    /**
     * Gets jedis对象池.
     *
     * @return Value of jedis对象池.
     */
    public Pool<Jedis> getPool() {
        return pool;
    }

    /**
     * Sets new jedis对象池.
     *
     * @param pool New value of jedis对象池.
     */
    public void setPool(Pool<Jedis> pool) {
        this.pool = pool;
    }
}
