package com.shareniu.common.redis;

import java.util.Set;

/**
 * redis manager
 *
 * <p>redis的操作接口</p>
 *
 * Created by wenzhouyang on 2015/1/15.
 */
public interface RedisManager {

    public byte[] get(byte[] key);

    public byte[] set(byte[] key, byte[] value);

    public byte[] set(byte[] key, byte[] value, int expire);

    public void del(byte[] key);

    public void flushDb(byte[] pattern);

    public Long dbSize(byte[] pattern);

    public Set<byte[]> keys(byte[] pattern);

    public Set<byte[]> values(byte[] pattern);
}
