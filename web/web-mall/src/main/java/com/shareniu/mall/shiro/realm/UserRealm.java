package com.shareniu.mall.shiro.realm;

import com.shareniu.mall.shiro.user.UserProvider;
import com.shareniu.mall.shiro.user.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zzx
 * @version 1.0
 * @since 1.0 Created by zyw on 2/8/2015.
 */
public class UserRealm extends AuthorizingRealm {

    private UserProvider userProvider;



    /**
     * 用户类型， 0：非商城用户 1：商城用户

     */
    private Integer userType;

    /**
     * Retrieves the AuthorizationInfo for the given principals from the underlying data store.  When returning
     * an instance from this method, you might want to consider using an instance of
     * {@link SimpleAuthorizationInfo SimpleAuthorizationInfo}, as it is suitable in most cases.
     *
     * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see SimpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (!principals.isEmpty()) {
            User user = (User) principals.getPrimaryPrincipal();
            String userId = user.getUserId();
            //获取权限和角色信息
            Set<Permission> permissionSet = user.getPermissions(userId);
            if (permissionSet == null) {
                permissionSet = new HashSet<Permission>();
            }
            Set<String> roleSet = user.getRoles(userId);
            if (roleSet == null) {
                roleSet = new HashSet<String>();
            }
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addObjectPermissions(permissionSet);
            authorizationInfo.addRoles(roleSet);
            return authorizationInfo;
        }
        return null;
    }

    /**
     * Retrieves authentication data from an implementation-specific datasource (RDBMS, LDAP, etc) for the given
     * authentication token.
     * <p/>
     * For most datasources, this means just 'pulling' authentication data for an associated subject/user and nothing
     * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
     * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
     * <p/>
     * A {@code null} return value means that no account could be associated with the specified token.
     *
     * @param token the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException if there is an error acquiring data or performing
     *                                                        realm-specific authentication logic for the specified <tt>token</tt>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userProvider.getUser(username);
        if (user == null) {
            throw new UnknownAccountException("根据用户名获取到的账户信息为空");
        }

        //if userType is not null then check userType else not check;
        if (userType != null) {
            Integer isBuyer = (Integer) user.getParameter("isBuyer");
            if (!userType.equals(isBuyer)) {
                throw new UnknownAccountException("获取到的用户类型不正确");
            }
        }

        //账户停用
        if (user.isDisabled()) {
            throw new DisabledAccountException();
        }

        //账号过期，锁定
        if (user.isExpired()) {
            throw new LockedAccountException();
        }

        //密码过期
        if (user.isPasswordExpired()) {
            throw new ExpiredCredentialsException();
        }

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()), getName());

        //清理密码信息
        user.clearPassword();
        return authenticationInfo;
    }

    /**
     * Gets userProvider.
     *
     * @return Value of userProvider.
     */
    public UserProvider getUserProvider() {
        return userProvider;
    }

    /**
     * Sets new userProvider.
     *
     * @param userProvider New value of userProvider.
     */
    public void setUserProvider(UserProvider userProvider) {
        this.userProvider = userProvider;
    }


    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
