package com.shareniu.common.cache.redis;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisClientTemplateImpl
  implements RedisClientTemplate
{
  private static ResourceBundle rb = ResourceBundle.getBundle("redis");
  private static int expire = Integer.parseInt(rb.getString("redis.expire"));

  @Autowired
  private RedisDataSource redisDataSource;

  public String set(String key, String value, int expire)
  {
    String result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.set(key, value);
      if (0 < expire)
        jedis.expire(key, expire);
    }
    catch (Exception e)
    {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public String get(String key)
  {
    return null;
  }

  public Boolean exists(String key)
  {
    Boolean result = Boolean.valueOf(false);
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.exists(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public boolean exists(byte[] key)
  {
    Boolean result = Boolean.valueOf(false);
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result.booleanValue();
    }
    boolean broken = false;
    try {
      result = jedis.exists(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result.booleanValue();
  }

  public String type(String key)
  {
    return null;
  }

  public String hmset(String key, Map<String, String> hash)
  {
    String result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hmset(key, hash);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public String hmset(byte[] key, Map<byte[], byte[]> hash)
  {
    String result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hmset(key, hash);
      jedis.expire(key, expire);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long hset(String key, String field, String value)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hset(key, field, value);
    }
    catch (Exception e)
    {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long hset(byte[] key, byte[] field, byte[] value)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hset(key, field, value);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Boolean hexists(String key, String field)
  {
    Boolean result = Boolean.valueOf(false);
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hexists(key, field);
    }
    catch (Exception e)
    {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Boolean hexists(byte[] key, byte[] field)
  {
    Boolean result = Boolean.valueOf(false);
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hexists(key, field);
    }
    catch (Exception e)
    {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public String hget(String key, String field)
  {
    String result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hget(key, field);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public byte[] hget(byte[] key, byte[] field)
  {
    byte[] result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.hget(key, field);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long del(String[] key)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.del(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long del(byte[][] key)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.del(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Set<String> keys(String pattern)
  {
    Set result = new HashSet();
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.keys(pattern);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Set<byte[]> keys(byte[] pattern)
  {
    Set result = new HashSet();
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.keys(pattern);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public byte[] rpop(byte[] key)
  {
    byte[] result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.rpop(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long rpush(byte[] key, byte[] value)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.rpush(key, new byte[][] { value });
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long llen(byte[] key)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.llen(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public List<byte[]> lrange(byte[] key, int start, int end)
  {
    List result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.lrange(key, start, end);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long expire(byte[] key, int seconds)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.expire(key, seconds);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public String set2(byte[] key, byte[] value, int sessionExpire)
  {
    String result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.set(key, value);
      jedis.expire(key, sessionExpire);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public byte[] getSession(byte[] key, int sessionExpire)
  {
    byte[] result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.get(key);
      if (null != result)
        jedis.expire(key, sessionExpire);
    }
    catch (Exception e)
    {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long rpush(String key, String value)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.rpush(key, new String[] { value });
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public String rpop(String key)
  {
    String result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.rpop(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long llen(String key)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.llen(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public String flushAll()
  {
    String result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return result;
    }
    boolean broken = false;
    try {
      result = jedis.flushAll();
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }

  public Long ttl(byte[] key)
  {
    Long result = null;
    Jedis jedis = this.redisDataSource.getRedisClient();
    if (null == jedis) {
      return null;
    }

    boolean broken = false;
    try {
      result = jedis.pttl(key);
    }
    catch (Exception e) {
      broken = true;
    } finally {
      this.redisDataSource.returnResource(jedis, broken);
    }
    return result;
  }







  @Override
  public byte[] get(byte[] key) {
    Jedis jedis = null;
    byte[] value = null;
    try {
      jedis = this.redisDataSource.getRedisClient();
      value = jedis.get(key);
    } finally {
     this.redisDataSource.returnResource(jedis);
    }
    return value;
  }

  @Override
  public byte[] set(byte[] key, byte[] value) {
    return set(key, value, 0);
  }

  public byte[] set(byte[] key, byte[] value, int expire) {
    Jedis jedis = null;
    try {
      jedis =this.redisDataSource.getRedisClient();
      jedis.set(key, value);
      if (expire > 0) {
        jedis.expire(key, expire);
      }
    } finally {
      this.redisDataSource.returnResource(jedis);
    }

    return value;
  }

  @Override
  public void del(byte[] key) {
    Jedis jedis = this.redisDataSource.getRedisClient();
    try {
      jedis.del(key);
    } finally {
      this.redisDataSource.returnResource(jedis);
    }
  }

  @Override
  public void flushDb(byte[] pattern) {
    Jedis jedis = this.redisDataSource.getRedisClient();
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
      this.redisDataSource.returnResource(jedis);
    }
  }

  @Override
  public Long dbSize(byte[] pattern) {
    Jedis jedis = this.redisDataSource.getRedisClient();
    long size = 0;
    try {
      Set<byte[]> keys = jedis.keys(pattern);
      size = keys.size();
    } finally {
      this.redisDataSource.returnResource(jedis);
    }

    return size;
  }



  @Override
  public Set<byte[]> values(byte[] pattern) {
    Jedis jedis = this.redisDataSource.getRedisClient();
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
      this.redisDataSource.returnResource(jedis);
    }
    return values;
  }
}