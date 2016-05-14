package com.shareniu.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shareniu.user.po.UserPo;
import com.shareniu.user.service.UserService;





/**
 * 
 * @描述: 用户信息管理 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-1-25,下午9:36:46 .
 * @版本号: V1.0 .
 */
@Controller
public class UserController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5588682213578275029L;

	private static Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 注册
	 */
	@RequestMapping("/register")
	public String register(UserPo userPo){
		userService.add(userPo);
		return "success";
	}
	/**
	 * 注册
	 */
	@RequestMapping("/update")
	public String update(UserPo userPo){
		userService.update(userPo);
		return "success";
	}
	/**
	 * 注册
	 */
	@RequestMapping("/delete")
	public String delete(UserPo userPo){
		userService.deleteUserByConf(userPo);
		return "success";
	}
	/**
	 * 注册
	 */
	@RequestMapping("/get")
	public String get(UserPo userPo){
		userService.getByConf(userPo);
		return "success";
	}
}
