package com.shareniu.mall.shiro.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * ajax utils
 *
 * Created by wenzhouyang on 2015/1/13.
 */
public class AjaxUtils {

    /**
     * 是否是ajax 请求
     *
     * @param request httpServletRequest
     *                @see javax.servlet.http.HttpServletRequest
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
}
