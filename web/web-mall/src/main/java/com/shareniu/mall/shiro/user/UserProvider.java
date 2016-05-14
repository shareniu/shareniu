package com.shareniu.mall.shiro.user;

import java.util.Map;
import java.util.Set;

/**
 * 用户信息接口
 *
 * Created by wenzhouyang on 2014/8/28.
 */
public interface UserProvider {

    /**
     * 根据用户名获取账户信息
     *
     * @param loginName 用户账户名
     * @return 用户账户信息(只需要返回账户表的信息即可,此接口仅在验证用户时候使用)
     */
    public User getUser(String loginName);

    /**
     * 获取全部权限
     *
     * key:url， value:permission
     * @return 全部权限
     */
    public Map<String, Set<String>> getAllPermission();

    /**
     * 清除所有权限缓存
     */
    public void cleanAllPermission();

    /**
     * 添加登陆日志
     *
     * @param userLoginLog 登陆日志
     * @return boolean
     */
    public boolean addUserLoginLog(Map<String, Object> userLoginLog);
}
