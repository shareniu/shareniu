package com.shareniu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shareniu.dao.UserDao;
import com.shareniu.dao.entity.UserEntity;
import com.shareniu.dao.mapper.UserEdt;
import com.shareniu.dao.mapper.UserSer;
import com.shareniu.user.po.UserPo;


/**
 * 
 * @描述: 用户表--服务层接口 .
 * @作者: WuShuicheng .
 * @创建时间: 2013-7-25,下午10:41:04 .
 * @版本: 1.0 .
 */
@Service
public class UserDaoImpl implements UserDao{
	@Autowired
	private UserSer userSer;
	@Autowired
	private UserEdt userEdt;

	/**
	 * 保存用户信息.
	 * @param pmsUser
	 */
	public void create(UserPo userPo) {
		UserEntity user=new UserEntity();
		BeanUtils.copyProperties(userPo, user);
		userEdt.insertTUser(user);
	}
	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            用户ID.
	 */
	public void deleteUserByConf(UserPo userPo) {
		UserEntity user=new UserEntity();
		user.setId(userPo.getUserId());
		userEdt.deleteTUser(user);
	}
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void update(UserPo userPo) {
		UserEntity user=new UserEntity();
		BeanUtils.copyProperties(userPo, user);
		userEdt.updateTUserByPrimaryKey(user);
	}
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public UserPo selectTUserByCond(UserPo userPo) {
	        UserEntity entity=userSer.selectTUserByCond(userPo);
	    	UserPo userPo2=new UserPo();
	    	BeanUtils.copyProperties(userPo2, entity);
	    	return userPo2;
	}
}