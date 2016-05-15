package com.shareniu.common.cache.redis;

import redis.clients.jedis.Jedis;

public  interface RedisDataSource
{
  public  Jedis getRedisClient();

  public  void returnResource(Jedis paramJedis);

  public  void returnResource(Jedis paramJedis, boolean paramBoolean);
}