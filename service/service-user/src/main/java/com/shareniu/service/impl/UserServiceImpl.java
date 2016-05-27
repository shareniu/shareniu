/**
 * 
 */
package com.shareniu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shareniu.dao.UserDao;
import com.shareniu.user.enums.EnumUsernameType;
import com.shareniu.user.po.UserPo;
import com.shareniu.user.service.UserService;

/**
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final String mobile = "^1[3-8]+\\d{9}";
	@Autowired
	private UserDao userDao;
	
	public void add(UserPo pmsUser) {
		userDao.create(pmsUser);
	}
	
	public void deleteUserByConf(UserPo userPo) {
		userDao.deleteUserByConf(userPo);
	}

	public void update(UserPo user) {
		userDao.update(user);
	}
	
	public void getByConf(UserPo user) {
		userDao.selectTUserByCond(user);
	}

	public UserPo queryUserByName(String loginName,
			EnumUsernameType usernameType) {
		// TODO Auto-generated method stub
		return null;
	}
	public UserPo getUser(String loginName) {
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
		UserPo userPo =queryUserByName(loginName, usernameType);
		if (userPo == null) {
			return null;
		}
		return userPo;
	}
	public void clearPassword(UserPo user){
		user.setPassword("");
	}
}
