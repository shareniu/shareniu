package com.shareniu.mall.shiro.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象用户信息类
 *
 * Created by wenzhouyang on 2015/1/13.
 */
public abstract class AbstractUser implements User {

	private Map<String, Object> paramMap = new ConcurrentHashMap<String, Object>();

	/**
	 * 获取参数信息
	 *
	 * @param key
	 *            参数key
	 * @return 参数信息
	 */
	@Override
	public Object getParameter(String key) {
		return paramMap.get(key);
	}

	/**
	 * 添加参数信息
	 *
	 * @param key
	 *            参数key
	 * @param value
	 *            参数value
	 */
	public void addParameter(String key, Object value) {
		if (value != null) {
			this.paramMap.put(key, value);
		}
	}

	/**
	 * 获取全部的其他信息
	 *
	 * @return 参数信息
	 */
	@Override
	public Map<String, Object> getParameters() {
		return paramMap;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AbstractUser{");
		sb.append("paramMap=");
		for (Map.Entry entry : paramMap.entrySet()) {
			sb.append("[").append(entry.getKey()).append(":")
					.append(entry.getValue()).append("]");
		}
		sb.append('}');
		return sb.toString();
	}
}
