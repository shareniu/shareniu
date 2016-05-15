package com.shareniu.common.cache.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisClientTemplate
{
  public  String flushAll();

  public byte[] set(byte[] key, byte[] value);

  public void del(byte[] key);

  public void flushDb(byte[] pattern);

  public Long dbSize(byte[] pattern);

  public Set<byte[]> values(byte[] pattern);

  public  String set(String paramString1, String paramString2, int paramInt);

  public  String set2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);

  public  String get(String paramString);

  public  byte[] get(byte[] paramArrayOfByte);

  public  byte[] getSession(byte[] paramArrayOfByte, int paramInt);

  public  Long del(String[] paramArrayOfString);

  public  Boolean exists(String paramString);

  public  Set<String> keys(String paramString);

  public  String type(String paramString);

  public  Long expire(byte[] paramArrayOfByte, int paramInt);

  public  String hmset(String paramString, Map<String, String> paramMap);

  public  Long hset(String paramString1, String paramString2, String paramString3);

  public  Boolean hexists(String paramString1, String paramString2);

  public  String hget(String paramString1, String paramString2);

  public  String hmset(byte[] paramArrayOfByte, Map<byte[], byte[]> paramMap);

  public  Boolean hexists(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public  Long hset(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);

  public  byte[] hget(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public  boolean exists(byte[] paramArrayOfByte);

  public  Set<byte[]> keys(byte[] paramArrayOfByte);

  public  Long del(byte[][] paramArrayOfByte);

  public  byte[] rpop(byte[] paramArrayOfByte);

  public  String rpop(String paramString);

  public  Long rpush(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public  Long llen(byte[] paramArrayOfByte);

  public  Long llen(String paramString);

  public  List<byte[]> lrange(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public  Long rpush(String paramString1, String paramString2);

  public  Long ttl(byte[] paramArrayOfByte);
  public byte[] set(byte[] key, byte[] value, int expire);
}