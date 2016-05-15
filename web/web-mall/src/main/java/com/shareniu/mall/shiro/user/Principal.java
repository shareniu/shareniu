package com.shareniu.mall.shiro.user;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 身份信息
 * @author liuqian
 * @version yyc 1.0
 * @since yyc 1.0 2014-5-21
 * @see 上午11:36:27
 */
public class Principal implements Serializable {

    private static final long serialVersionUID = 5798882004228239559L;

    /** ID */
    private BigInteger id;

    /** 用户名 */
    private String username;

    /** 企业ID: -1 - 平台管理员 其他-企业 */
    private BigInteger entId;

    /**
     * 区域店铺ID
     */
    private BigInteger storeId;

    /**
     * 企业名称
     */
    private String entName;
    
    /**
     * 角色Id
     */
    private BigInteger roleId;
    
    /**
     * 是否为主账号：0-非 1-是
     */
    private String isMain;

    /**
     * @param id
     *            ID
     * @param username
     *            用户名
     */
    public Principal(BigInteger id, String username) {
        this.id = id;
        this.username = username;
    }

    /**
     * @param id
     *            ID
     * @param username
     *            用户名
     * @param entId
     *            企业ID
     * @param storeId
     *            区域店铺ID
     */
    public Principal(BigInteger id, String username, BigInteger entId, BigInteger storeId, String entName,BigInteger roleId,String isMain) {
        this.id = id;
        this.username = username;
        this.entId = entId;
        this.storeId = storeId;
        this.entName = entName;
        this.roleId=roleId;
        this.isMain=isMain;
    }

    /**
     * 获取ID
     * 
     * @return ID
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * 设置ID
     * 
     * @param id
     *            ID
     */
    public void setId(BigInteger id) {
        this.id = id;
    }

    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * 
     * @param username
     *            用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }

    /**
     * @return
     */
    public BigInteger getEntId() {
        return entId;
    }

    /**
     * @param
     */
    public void setEntId(BigInteger entId) {
        this.entId = entId;
    }

    /**
     * @return
     */
    public BigInteger getStoreId() {
        return storeId;
    }

    /**
     * @param
     */
    public void setStoreId(BigInteger storeId) {
        this.storeId = storeId;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public BigInteger getRoleId() {
        return roleId;
    }

    public void setRoleId(BigInteger roleId) {
        this.roleId = roleId;
    }

	public String getIsMain() {
        return isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

    
}