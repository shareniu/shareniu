package com.shareniu.common.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisDataSourceImpl
  implements RedisDataSource
{

  @Autowired
  private JedisPool jedisPool;

  public Jedis getRedisClient()
  {
    try
    {
      return this.jedisPool.getResource();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void returnResource(Jedis jedis)
  {
    this.jedisPool.returnResource(jedis);
  }

  public void returnResource(Jedis jedis, boolean broken)
  {
    if (broken)
      this.jedisPool.returnBrokenResource(jedis);
    else
      this.jedisPool.returnResource(jedis);
  }
}