package com.shareniu.mall.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shareniu.user.po.UserPo;
import com.shareniu.user.service.UserService;

/**
 * 
 * @创建时间: 2015-1-25,下午7:50:22 .
 * @版本号: V1.0 .
 */
@Controller
public class LoginController{
	@Autowired
	private UserService userService;


	/**
	 * 进入登录页面.
	 * 
	 * @return
	 */
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

	/**
	 * 登录验证Action
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userLogin")
	public String userLogin(UserPo user) {
		try {
			

		} catch (RuntimeException e) {
			return "input";
		} catch (Exception e) {
			return "input";
		}
		return "index";
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout() throws Exception {
		return "logout";
	}
}
