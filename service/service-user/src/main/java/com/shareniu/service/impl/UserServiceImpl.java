/**
 * 
 */
package com.shareniu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shareniu.dao.UserDao;
import com.shareniu.user.enums.EnumUsernameType;
import com.shareniu.user.po.MemUserLoginPo;
import com.shareniu.user.po.UserPo;
import com.shareniu.user.service.UserService;

/**
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	/**
	 * 保存用户信息.
	 * @param pmsUser
	 */
	public void add(UserPo pmsUser) {
		userDao.create(pmsUser);
	}
	
	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            用户ID.
	 */
	public void deleteUserByConf(UserPo userPo) {
		userDao.deleteUserByConf(userPo);
	}

	
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void update(UserPo user) {
		userDao.update(user);
	}
	
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void getByConf(UserPo user) {
		userDao.selectTUserByCond(user);
	}

	@Override
	public MemUserLoginPo queryUserByName(String loginName,
			EnumUsernameType usernameType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
