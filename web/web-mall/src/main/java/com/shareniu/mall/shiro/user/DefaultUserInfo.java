package com.shareniu.mall.shiro.user;

import org.apache.shiro.authz.Permission;

import java.util.Set;

/**
 * 默认的用户账号信息
 *
 * Created by wenzhouyang on 2015/1/13.
 */
public class DefaultUserInfo extends AbstractUser {
    private static final long serialVersionUID = 2387698145670985425L;
    private String userId;

    private String loginName;

    private String password;

    private String salt;

    private boolean disabled;

    private boolean locked;

    private boolean expired;

    private boolean passwordExpired;

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getSalt() {
        return salt;
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public boolean isPasswordExpired() {
        return passwordExpired;
    }

    @Override
    public void clearPassword() {
        this.password = null;
        this.salt = null;
    }

    /**
     * 根据用户userLoginId获取当前用户有哪些权限
     *
     * @param userLoginId 用户账户id
     * @return 当前用户权限信息
     */
    @Override
    public Set<Permission> getPermissions(String userLoginId) {
        return null;
    }

    /**
     * 获取用户角色信息
     *
     * @param userLoginId 用户账户id
     * @return 当前用户角色信息
     */
    @Override
    public Set<String> getRoles(String userLoginId) {
        return null;
    }


    /**
     * Sets new disabled.
     *
     * @param disabled New value of disabled.
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * Sets new locked.
     *
     * @param locked New value of locked.
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Sets new expired.
     *
     * @param expired New value of expired.
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * Sets new userId.
     *
     * @param userId New value of userId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Sets new password.
     *
     * @param password New value of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets new loginName.
     *
     * @param loginName New value of loginName.
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Sets new passwordExpired.
     *
     * @param passwordExpired New value of passwordExpired.
     */
    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    /**
     * Sets new salt.
     *
     * @param salt New value of salt.
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultUserInfo{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", loginName='").append(loginName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", salt='").append(salt).append('\'');
        sb.append(", disabled=").append(disabled);
        sb.append(", locked=").append(locked);
        sb.append(", expired=").append(expired);
        sb.append(", passwordExpired=").append(passwordExpired);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
