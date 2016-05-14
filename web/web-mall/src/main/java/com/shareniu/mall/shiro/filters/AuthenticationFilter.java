package com.shareniu.mall.shiro.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.shareniu.common.constants.SessionConstants;
import com.shareniu.common.utils.SpringUtils;
import com.shareniu.mall.shiro.user.User;
import com.shareniu.mall.shiro.user.UserProvider;
import com.shareniu.mall.shiro.utils.AjaxUtils;
import com.shareniu.mall.shiro.utils.ExceptionMessage;
import com.shareniu.user.po.MemPersonPo;

/**
 * 认证filter
 *
 * Created by wenzhouyang on 2015/1/13.
 */
public class AuthenticationFilter extends FormAuthenticationFilter {

	private static final Logger log = LoggerFactory
			.getLogger(AuthenticationFilter.class);

	private UserProvider userProvider;

	/** 登陆 COOKIE名称 */
	private static final String USERNAME_COOKIE_NAME = "mallUser";

	/** 昵称 COOKIE名称 */
	private static final String USERNICK_COOKIE_NAME = "userNick";
	
	/** UID COOKIE名称 */
	private static final String USERID_COOKIE_NAME = "userPin";

	public static final String DEFAULT_CALLBACK_KEY_ATTRIBUTE_NAME = "callback";
	public static final String SESSION_CALLBACK_KEY = "shiroSessionCallbackKey";

	/**
	 * 回调url key
	 */
	private String callbackKeyAttribute = DEFAULT_CALLBACK_KEY_ATTRIBUTE_NAME;

	/**
	 * Determines whether the current subject should be allowed to make the
	 * current request.
	 * <p/>
	 * The default implementation returns <code>true</code> if the user is
	 * authenticated. Will also return <code>true</code> if the
	 * {@link #isLoginRequest} returns false and the &quot;permissive&quot; flag
	 * is set.
	 *
	 * @param request
	 *            ServletRequest
	 * @param response
	 *            ServletResponse
	 * @param mappedValue
	 *            mappedValue
	 * @return <code>true</code> if request should be allowed access
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		// 当前的用户已经登陆了，但是又在请求登陆页面,只针对同步
		if (subject.isAuthenticated() && isLoginRequest(request, response)) {
			try {
				issueSuccessRedirect(request, response);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return super.isAccessAllowed(request, response, mappedValue);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			if (isLoginSubmission(request, response)) {
				if (log.isTraceEnabled()) {
					log.trace("Login submission detected.  Attempting to execute login.");
				}
				return executeLogin(request, response);
			} else {
				if (log.isTraceEnabled()) {
					log.trace("Login page view.");
				}
				// 请求登陆页面，检查当前请求是否有callback链接
				String callback = request
						.getParameter(getCallbackKeyAttribute());
				if (callback != null && callback.trim().length() > 0) {
					saveCallback(request, response, callback.trim());
				}
				// allow them to see the login page ;)
				return true;
			}
		} else {
			// 非登陆页面请求
			if (AjaxUtils.isAjaxRequest((HttpServletRequest) request)) {
				// 异步请求，返回错误代码，由前端判断并进行登陆页跳转
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.addHeader(SessionConstants.LOGIN_URL, getLoginUrl());
				resp.addHeader(SessionConstants.LOGIN_STATUS,
						SessionConstants.LOGIN_ACCESS_DENIED);
				resp.sendError(HttpServletResponse.SC_FORBIDDEN);
				return false;
			} else {
				// 同步请求，重定向到登陆页面
				if (log.isTraceEnabled()) {
					log.trace("Attempting to access a path which requires authentication.  Forwarding to the "
							+ "Authentication url [" + getLoginUrl() + "]");
				}
                saveCallback(request, response, ((HttpServletRequest)(request)).getRequestURI());
				saveRequestAndRedirectToLogin(request, response);

				return false;
			}
		}
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		// 记录登陆日志
		userProvider.addUserLoginLog(null);
		String successUrl = getSuccessUrl();
		String callback = getAndClearCallback(request, response);
		if (callback != null) {
			successUrl = callback;
		}

		User user = (User) subject.getPrincipal();
		com.shareniu.common.utils.WebUtils.addCookie(WebUtils.toHttp(request),
				WebUtils.toHttp(response), USERNAME_COOKIE_NAME,
				user.getLoginName());
		com.shareniu.common.utils.WebUtils.addCookie(WebUtils.toHttp(request),
				WebUtils.toHttp(response), USERID_COOKIE_NAME,
				user.getUserId());
		MemPersonPo memPersonPo = (MemPersonPo) user
				.getParameter("PARTY_INFO_KEY");
		// 用户昵称
		if (memPersonPo != null) {
			com.shareniu.common.utils.WebUtils.addCookie(WebUtils.toHttp(request),
					WebUtils.toHttp(response), USERNICK_COOKIE_NAME,
					memPersonPo.getNickname());
		}
		// 如果当前是ajax登陆
		if (AjaxUtils.isAjaxRequest((HttpServletRequest) request)) {
			// 登陆成功返回，状态码
			response.setContentType("text/html;charset=UTF-8");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SessionConstants.LOGIN_STATUS,
					SessionConstants.LOGIN_SUCCESS);
			map.put(getCallbackKeyAttribute(), successUrl);
			response.getWriter().write(new Gson().toJson(map));
		} else {
			// 同步登陆
			WebUtils.issueRedirect(request, response, successUrl);
		}
		return false;
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		// 获取当前异常的类名
		String className = e.getClass().getName();
		String failureCode = ExceptionMessage.getFailureMsg(className);
		String msg = SpringUtils.getMessage(failureCode);
		if (AjaxUtils.isAjaxRequest((HttpServletRequest) request)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(SessionConstants.LOGIN_STATUS,
					SessionConstants.LOGIN_FAILURE);
			map.put(getFailureKeyAttribute(), msg);
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(new Gson().toJson(map));
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
			return false;
		} else {
			request.setAttribute(getFailureKeyAttribute(), msg);
			return true;
		}
	}

	/**
	 * 保存回调地址
	 *
	 * @param request
	 *            ServletRequest
	 * @param response
	 *            ServletResponse
	 * @param callback
	 *            callback
	 */
	private void saveCallback(ServletRequest request, ServletResponse response,
			String callback) {
		Subject subject = getSubject(request, response);
		Session session = subject.getSession();
		session.setAttribute(SESSION_CALLBACK_KEY, callback);
	}

	/**
	 * 获取并清理掉回调地址
	 *
	 * @param request
	 *            ServletRequest
	 * @param response
	 *            ServletResponse
	 * @return callback
	 */
	private String getAndClearCallback(ServletRequest request,
			ServletResponse response) {
		Subject subject = getSubject(request, response);
		Session session = subject.getSession(false);
		if (session == null) {
			return null;
		}

		String callback = (String) session.getAttribute(SESSION_CALLBACK_KEY);
		if (callback != null) {
			session.removeAttribute(SESSION_CALLBACK_KEY);
		}
		return callback;
	}

	/**
	 * Sets new userProvider.
	 *
	 * @param userProvider
	 *            New value of userProvider.
	 */
	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}

	/**
	 * Sets new 回调url key.
	 *
	 * @param callbackKeyAttribute
	 *            New value of 回调url key.
	 */
	public void setCallbackKeyAttribute(String callbackKeyAttribute) {
		this.callbackKeyAttribute = callbackKeyAttribute;
	}

	/**
	 * Gets 回调url key.
	 *
	 * @return Value of 回调url key.
	 */
	public String getCallbackKeyAttribute() {
		return callbackKeyAttribute;
	}
}
