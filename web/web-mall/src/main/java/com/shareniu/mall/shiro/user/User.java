package com.shareniu.mall.shiro.user;

import org.apache.shiro.authz.Permission;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * 登录账户信息操作接口
 *
 * <p>主要通过本接口对当前登录的用户信息进行操作</p>
 *
 * Created by wenzhouyang on 2015/1/13.
 */
public interface User extends Serializable {

    /**
     * 获取用户账号Id
     *
     * @return 用户账号Id
     */
    public String getUserId();

    /**
     * 获取登录的账号名称
     *
     * @return 账号名称
     */
    public String getLoginName();

    /**
     * 获取用户密码
     *
     *  <p>登陆后本方法获取不到用户的密码</p>
     *
      * @return 用户密码
     */
    public String getPassword();

    /**
     * 获取盐
     * <p>主要用户密码加密使用</p>
     * @return 盐
     */
    public String getSalt();

    /**
     * 账号是否停用
     *
     * @return 是否停用
     */
    public boolean isDisabled();

    /**
     * 账号是否已锁
     *
     * @return 是否已锁
     */
    public boolean isLocked();

    /**
     * 账号是否已过期
     *
     * @return 是否过期
     */
    public boolean isExpired();

    /**
     * 密码是否已过期
     *
     * @return 密码是否过期
     */
    public boolean isPasswordExpired();

    /**
     * 清理密码信息
     *
     * <p>主要用于登录验证后清理密码信息，不将敏感信息存储到session中</p>
     */
    public void clearPassword();

    /**
     * 获取其他参数信息
     *
     * @param key 参数key
     * @return 参数信息
     */
    public Object getParameter(String key);

    /**
     * 获取全部的其他信息
     *
     * @return 参数信息
     */
    public Map<String, Object> getParameters();

    /**
     * 根据用户userLoginId获取当前用户有哪些权限
     *
     * @param userLoginId 用户账户id
     * @return 当前用户权限信息
     */
    public Set<Permission> getPermissions(String userLoginId);

    /**
     * 获取用户角色信息
     *
     * @param userLoginId 用户账户id
     * @return 当前用户角色信息
     */
    public Set<String> getRoles(String userLoginId);
}
