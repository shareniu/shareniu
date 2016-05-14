package com.shareniu.common.constants;
public interface SessionConstants {

    /**
     * 登陆url
     */
    String LOGIN_URL = "loginUrl";

    /**
     * 登陆成功的url
     */
    String SUCCESS_URL = "successUrl";

    /**
     * 登陆状态key
     */
    String LOGIN_STATUS = "loginStatus";

    /**
     * 成功
     */
    String LOGIN_SUCCESS = "success";

    /**
     * 失败
     */
    String LOGIN_FAILURE = "failure";


    /**
     * 禁止访问-需要登陆操作
     */
    String LOGIN_ACCESS_DENIED = "accessDenied";

    /**
     * 禁止访问-无权限
     */
    String LOGIN_ACCESS_FORBIDDEN = "accessForbidden";

    String PARTY_KEY = "PARTY_INFO_KEY";

    String EMAIL_KEY = "EMIAL_INFO_KEY";

    String MOBILE_KEY = "MOBILE_INFO_KEY";
}
