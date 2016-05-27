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

    /** 会员ID */
    private Integer id;
    private String username;

    /** 真实姓名 */
    private String realname;

    /** 密码 */
    private String password;

    private String nickname;

    private String mobile;
    private String email;

    private Integer status;

    private Integer locked;

    private String randomSalt;



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
    public String getPassword() {
        return password;
    }

    /**
     * @param
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getRandomSalt() {
        return randomSalt;
    }

    public void setRandomSalt(String randomSalt) {
        this.randomSalt = randomSalt;
    }
}
