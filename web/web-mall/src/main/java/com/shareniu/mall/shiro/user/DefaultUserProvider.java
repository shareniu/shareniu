package com.shareniu.mall.shiro.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.shareniu.common.constants.SessionConstants;
import com.shareniu.user.enums.EnumBoolean;
import com.shareniu.user.enums.EnumUsernameType;
import com.shareniu.user.po.MemUserLoginPo;
import com.shareniu.user.service.UserService;

/**
 * Created by wenzhouyang on 2015/1/13.
 */
public class DefaultUserProvider implements UserProvider {

    @Autowired
    private UserService userService;

    private static final String mobile = "^1[3-8]+\\d{9}";

    @Override
    public User getUser(String loginName) {
    	if(loginName == null) {
    		return null;
    	}

        EnumUsernameType usernameType;

        if (loginName.matches(mobile)) {
            //手机号
            usernameType = EnumUsernameType.MOBILE;
        } else if (loginName.indexOf("@") > 0) {
            //邮箱
            usernameType = EnumUsernameType.EMAIL;
        } else {
            //用户名
            usernameType = EnumUsernameType.USERNAME;
        }

        //查询账号
        MemUserLoginPo memUserLoginPo =userService.queryUserByName(loginName, usernameType);


        if (memUserLoginPo == null) {
            return null;
        }

        DefaultUserInfo userInfo = new DefaultUserInfo();
        userInfo.setUserId(String.valueOf(memUserLoginPo.getUserLoginId()));
        userInfo.setPassword(memUserLoginPo.getPassword());
        userInfo.setSalt(memUserLoginPo.getRandomSalt());
        userInfo.setLoginName(memUserLoginPo.getUserName());

        if (EnumBoolean.FALSE.compare(memUserLoginPo.getEnabled())) {
            userInfo.setDisabled(true);
        }

        if (EnumBoolean.TRUE.compare(memUserLoginPo.getLocked())) {
            userInfo.setLocked(true);
        }

        userInfo.setExpired(false);
        userInfo.setPasswordExpired(false);
        userInfo.addParameter(SessionConstants.PARTY_KEY, memUserLoginPo.getMemPersonPo());
        userInfo.addParameter(SessionConstants.EMAIL_KEY, memUserLoginPo.getEmail());
        userInfo.addParameter(SessionConstants.MOBILE_KEY, memUserLoginPo.getTel());

        return userInfo;
    }

    @Override
    public Map<String, Set<String>> getAllPermission() {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Set<String> set = new HashSet<String>();
        set.add("*:*");
        map.put("*", set);
        return map;
    }

    @Override
    public void cleanAllPermission() {

    }

    @Override
    public boolean addUserLoginLog(Map<String, Object> userLoginLog) {
        System.out.println("用户登录了");
        return true;
    }
}
