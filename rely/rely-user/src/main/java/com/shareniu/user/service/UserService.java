/**
 * 
 */
package com.shareniu.user.service;

import com.shareniu.user.enums.EnumUsernameType;
import com.shareniu.user.po.MemUserLoginPo;
import com.shareniu.user.po.UserPo;

/**
 * @描述: 用户Dubbo服务接口 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-1-26,上午1:41:38 .
 * @版本号: V1.0 .
 */
public interface UserService {
	/**
	 * 保存用户信息.
	 * @param pmsUser
	 */
	public void add(UserPo pmsUser);
	
   /**
	 * @param id
	 *            用户ID.
	 */
	public void deleteUserByConf(UserPo userId);

	
	/**
	 * 更新用户信息.
	 * @param user
	 */
	public void update(UserPo user);
	
	/**
	 * 查询用户信息.
	 * @param user
	 */
	public void getByConf(UserPo user);

	public MemUserLoginPo queryUserByName(String loginName,
			EnumUsernameType usernameType);
	
}
