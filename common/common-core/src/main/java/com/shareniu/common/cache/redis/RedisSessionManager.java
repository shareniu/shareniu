package com.shareniu.common.cache.redis;

import java.util.HashMap;

public abstract interface RedisSessionManager
{
  public abstract void setSession(HashMap<String, Object> paramHashMap, int paramInt);

  public abstract HashMap<String, Object> getSession(String paramString, int paramInt);

  public abstract void invalidate(String paramString);
}