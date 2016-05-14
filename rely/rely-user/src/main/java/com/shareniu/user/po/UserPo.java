/*
 * Copyright(c) 2012-2014 JD Pharma.Ltd. All Rights Reserved.
 */
package com.shareniu.user.po;


/**
 * 会员PO
 * @author liuqian
 * @version yyc 1.0
 * @since yyc 1.0 2014-5-21
 * @see 下午3:29:54
 */
public class UserPo {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -6639222900202459362L;

    /** "身份信息"参数名称 */
    public static final String PRINCIPAL_ATTRIBUTE_NAME = UserPo.class.getName() + ".PRINCIPAL";
    
    /** "身份信息"参数名称 */
    public static final String PRINCIPALAll_ATTRIBUTE_NAME = UserPo.class.getName() + ".PRINCIPALAll";

    /** "用户PIN"Cookie名称 */
    public static final String USERPIN_COOKIE_NAME = "userpin";
    
    /** "用户名"Cookie名称 */
    public static final String USER_COOKIE_NAME = "username";
    
    /** "用户名"Cookie名称 */
    public static final String USER_COOKIE_USERID= "userid";
    
    /** "用户IP"Cookie名称 */
    public static final String USERIP_COOKIE_NAME = "userip";

    /** 会员ID */
    private Integer userId;

    private String pin;

    /** 真实姓名 */
    private String realname;

    /** 用户名 */
    private String nickname;
    
    /** 昵称**/
    private String nicknameShow;

    /** 密码 */
    private String password;

    /** 会员等级 */
    private Integer userLevel;
    
    /** 会员等级 */
    private String userLevelStr;
    
    /** 会员图标CSS */
    private String userLevelCss;
    
    /** 所在省**/
    private Integer province;
    
    /** 所在市**/
    private Integer city;
    

    /**
     * @return
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * @return
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * @param
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * @return
     */
    public String getUserLevelStr() {
        return userLevelStr;
    }

    /**
     * @param
     */
    public void setUserLevelStr(String userLevelStr) {
        this.userLevelStr = userLevelStr;
    }

    /**
     * @return
     */
    public String getUserLevelCss() {
        return userLevelCss;
    }

    /**
     * @param
     */
    public void setUserLevelCss(String userLevelCss) {
        this.userLevelCss = userLevelCss;
    }

	public String getNicknameShow() {
		return nicknameShow;
	}

	public void setNicknameShow(String nicknameShow) {
		this.nicknameShow = nicknameShow;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}
}
