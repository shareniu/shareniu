package com.shareniu.mall.shiro.realm;

import com.shareniu.user.po.UserPo;
import com.shareniu.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author zzx
 * @version 1.0
 * @since 1.0 Created by zyw on 2/8/2015.
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*if (!principals.isEmpty()) {
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
        }*/
        return null;
    }

    /**
     *
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserPo user = userService.getUser(username);
        if (user == null) {
            throw new UnknownAccountException("根据用户名获取到的账户信息为空");
        }
        //账户停用
        if (user.getStatus().equals(0)) {
            throw new DisabledAccountException();
        }
        //账号过期，锁定
        if (user.getLocked().equals(1)) {
            throw new LockedAccountException();
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getRandomSalt()), getName());
        //清理密码信息
        userService.clearPassword(user);
        return authenticationInfo;
    }
}
