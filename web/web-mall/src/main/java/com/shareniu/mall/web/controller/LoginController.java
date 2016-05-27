package com.shareniu.mall.web.controller;

import com.shareniu.common.utils.WebUtils;
import com.shareniu.mall.shiro.utils.AjaxUtils;
import com.shareniu.user.po.UserPo;
import com.shareniu.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * asaaa
 * @版本号: V1.0 .12
 */
@Controller
public class LoginController{
	@Autowired
	private UserService userService;
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public String login(String ReturnUrl, HttpServletRequest request,
						HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			if (ReturnUrl == null || ReturnUrl.equals("")) {
				return "index/main";
			}
			return ReturnUrl;
		} else {
			return "error";
		}
	}
	@RequestMapping("/logout")
	public String logOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	/**
	 * 是否登录
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/isLogin")
	@ResponseBody
	public  Object isLogin(HttpServletRequest request,HttpServletResponse response) {
		boolean isAuthenticated = SecurityUtils.getSubject().isAuthenticated();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> identify = new HashMap<String, Object>();
		String name = WebUtils.getCookie(request, "mallUser");
		if (name == null) {
			name = "";
		} else {
			try {
				name = URLDecoder.decode(name, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				name = "";
			}
		}
		String unick = WebUtils.getCookie(request, "userNick");
		if (unick == null) {
			unick = "";
		} else {
			try {
				unick = URLDecoder.decode(unick, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				unick = "";
			}
		}
		String userPin = WebUtils.getCookie(request, "userPin");
		if (userPin == null) {
			userPin = "";
		} else {
			try {
				userPin = URLDecoder.decode(userPin, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				userPin = "";
			}
		}
		identify.put("Unick", unick);
		identify.put("Name", name);
		identify.put("UserPin", userPin);
		identify.put("IsAuthenticated", isAuthenticated);
		map.put("Identity", identify);
		//AjaxUtils.toJson(map, response);
	   return map;
	}

	@RequestMapping("/getUserPo")
	public @ResponseBody UserPo getUserPo() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			UserPo user = (UserPo) subject.getPrincipal();
				return user;
		}
		return null;
	}
	/**
	 * 弹出登陆框
	 *
	 * @author liuqian
	 * @return
	 */
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "index/login_box";
	}
}
