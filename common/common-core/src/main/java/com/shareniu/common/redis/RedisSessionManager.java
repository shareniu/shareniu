package com.shareniu.common.redis;

import java.util.HashMap;

public interface RedisSessionManager {
    void setSession(HashMap<String, Object> var1, int var2);

    HashMap<String, Object> getSession(String var1, int var2);

    void invalidate(String var1);
}
