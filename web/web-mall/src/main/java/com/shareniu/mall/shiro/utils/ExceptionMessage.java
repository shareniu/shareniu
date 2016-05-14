package com.shareniu.mall.shiro.utils;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;

/**
 * 登陆异常信息
 *
 * Created by wzy on 2015/4/6.
 */
public class ExceptionMessage {

    private static final String UNSUPPORTED_TOKEN = "login.unsupportedToken";
    private static final String UNKNOWN_ACCOUNT = "login.unknownAccount";
    private static final String INCORRECT_CREDENTIALS = "login.incorrectCredentials";
    private static final String DISABLED_ACCOUNT = "login.disabledAccount";
    private static final String LOCKED_ACCOUNT = "login.lockedAccount";
    private static final String AUTHENTICATION = "login.authentication";
    private static final String ACCOUNT_EXCEPTION = "login.accountException";
    private static final String EXPIRED_CREDENTIALS = "login.expiredCredentials";
    private static final String LOGIN_FAILURE = "login.failure";

    public static String getFailureMsg(String className) {
        if (className.equals(UnsupportedTokenException.class.getName())) {
            return UNSUPPORTED_TOKEN;
        } else if (className.equals(UnknownAccountException.class.getName())) {
            return UNKNOWN_ACCOUNT;
        } else if (className.equals(IncorrectCredentialsException.class.getName())) {
            return INCORRECT_CREDENTIALS;
        } else if (className.equals(DisabledAccountException.class.getName())) {
            return DISABLED_ACCOUNT;
        } else if (className.equals(LockedAccountException.class.getName())) {
            return LOCKED_ACCOUNT;
        } else if (className.equals(AuthenticationException.class.getName())) {
            return AUTHENTICATION;
        } else if (className.equals(AccountException.class.getName())) {
            return ACCOUNT_EXCEPTION;
        } else if (className.equals(ExpiredCredentialsException.class.getName())) {
            return EXPIRED_CREDENTIALS;
        } else {
            return LOGIN_FAILURE;
        }
    }

    public static String getDefaultMessage(String code) {
        if (UNSUPPORTED_TOKEN.equals(code)) {
            return "用户名或密码错误！";
        } else if (UNKNOWN_ACCOUNT.equals(code)) {
            return "用户名不存在！";
        } else if (INCORRECT_CREDENTIALS.equals(code)) {
            return "密码错误！";
        } else if (DISABLED_ACCOUNT.equals(code)) {
            return "用户名已停用！";
        } else if (LOCKED_ACCOUNT.equals(code)) {
            return "用户名已锁定！";
        } else if (AUTHENTICATION.equals(code)) {
            return "登陆失败！";
        } else if (EXPIRED_CREDENTIALS.equals(code)) {
            return "密码已过期！";
        } else if (LOGIN_FAILURE.equals(code)) {
            return "登陆失败！";
        } else {
            return "登陆失败！";
        }
    }


}
