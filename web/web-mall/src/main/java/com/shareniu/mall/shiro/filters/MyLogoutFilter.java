package com.shareniu.mall.shiro.filters;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.LogoutFilter;

import com.shareniu.common.cache.redis.RedisSessionManager;
import com.shareniu.common.utils.WebUtils;
import com.shareniu.user.po.UserPo;

/**
 * Created by wzy on 2015/4/8.
 */
public class MyLogoutFilter extends LogoutFilter {

    @Resource
    private RedisSessionManager redisSessionManager;

    /** JSESSIONID COOKIE名称2 */
    private static final String JSESSIONID_COOKIE_NAME = "userSessionId";

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        if (redisSessionManager != null) {
            String sessionId = WebUtils.getCookie((HttpServletRequest) request, JSESSIONID_COOKIE_NAME);
            if (sessionId != null) {
                redisSessionManager.invalidate(sessionId);
            }
        }
        return super.preHandle(request, response);
    }

    /**
     * Sets new redisSessionManager.
     *
     * @param redisSessionManager New value of redisSessionManager.
     */
    public void setRedisSessionManager(RedisSessionManager redisSessionManager) {
        this.redisSessionManager = redisSessionManager;
    }
}
