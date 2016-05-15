package com.shareniu.common.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RedisSessionMangerImpl
  implements RedisSessionManager
{

  @Autowired
  private RedisClientTemplate redisClientTemplate;
  public static final DeserializingConverter deserializingConverter = new DeserializingConverter();

  public static final SerializingConverter converter = new SerializingConverter();

  public void setSession(HashMap<String, Object> map, int seconds)
  {
    String sessionId = (String)map.get("sessionId");
    this.redisClientTemplate.set(converter.convert(sessionId), converter.convert(map), seconds);
  }

  public HashMap<String, Object> getSession(String sessionId, int seconds)
  {
    byte[] result = this.redisClientTemplate.getSession(converter.convert(sessionId), seconds);
    if (null == result) {
      return null;
    }
    return (HashMap)deserializingConverter.convert(result);
  }

  public void invalidate(String sessionId)
  {
    this.redisClientTemplate.del(new byte[][] { converter.convert(sessionId) });
  }
}