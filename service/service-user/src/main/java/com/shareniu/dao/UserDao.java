package com.shareniu.dao;

import com.shareniu.user.po.UserPo;


/**
 * 
 * @描述: 用户表--服务层接口 .
 * @作者: WuShuicheng .
 * @创建时间: 2013-7-25,下午10:41:04 .
 * @版本: 1.0 .
 */
public interface UserDao {
	/**
	 * 保存用户信息.
	 * @param pmsUser
	 */
	public void create(UserPo userPo);
	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            用户ID.
	 */
	public void deleteUserByConf(UserPo userPo);
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void update(UserPo userPo);
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public UserPo selectTUserByCond(UserPo userPo);
}