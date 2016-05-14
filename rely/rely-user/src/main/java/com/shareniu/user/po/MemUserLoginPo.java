package com.shareniu.user.po;


import java.math.BigInteger;
import java.util.Date;

/**
 * 账号 Po
 *
 * @author wzy
 * @since 1.0
 */
public class MemUserLoginPo{
    private static final long serialVersionUID = -6755624621260841771L;
    /**
     * 用户账号ID
     */
    private BigInteger userLoginId;
    /**
     * 会员基础ID
     */
    private BigInteger partyId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 随机盐
     */
    private String randomSalt;
    /**
     * 是否系统账户
     */
    private Integer system;
    /**
     * 是否注册完成
     */
    private Integer hadSingup;
    /**
     * 账号是否可用
     */
    private Integer enabled;
    /**
     * 账号是否锁定
     */
    private Integer locked;
    /**
     * 账号是否过期
     */
    private Integer expired;
    /**
     * 密码是否过期
     */
    private Integer passwordExpired;
    /**
     * 密码过期时间
     */
    private Date pwExpiredTime;
    /**
     * 组织ID
     */
    private BigInteger partyGroupId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 会员个人信息
     */
    private MemPersonPo memPersonPo;
   
    
    private String tel;
    private String email;


    /**
     * 邀请码，注册时候才会用到
     */
    private String inviteCode;

    /**
     * Gets 账号是否过期.
     *
     * @return Value of 账号是否过期.
     */
    public Integer getExpired() {
        return expired;
    }

    /**
     * Gets 创建时间.
     *
     * @return Value of 创建时间.
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Sets new 用户名.
     *
     * @param userName New value of 用户名.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Sets new 是否注册完成.
     *
     * @param hadSingup New value of 是否注册完成.
     */
    public void setHadSingup(Integer hadSingup) {
        this.hadSingup = hadSingup;
    }

    /**
     * Gets 组织ID.
     *
     * @return Value of 组织ID.
     */
    public BigInteger getPartyGroupId() {
        return partyGroupId;
    }

    /**
     * Sets new 用户账号ID.
     *
     * @param userLoginId New value of 用户账号ID.
     */
    public void setUserLoginId(BigInteger userLoginId) {
        this.userLoginId = userLoginId;
    }

    /**
     * Gets 更新时间.
     *
     * @return Value of 更新时间.
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * Gets 账号是否可用.
     *
     * @return Value of 账号是否可用.
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * Gets 用户账号ID.
     *
     * @return Value of 用户账号ID.
     */
    public BigInteger getUserLoginId() {
        return userLoginId;
    }

    /**
     * Gets 是否系统账户.
     *
     * @return Value of 是否系统账户.
     */
    public Integer getSystem() {
        return system;
    }

    /**
     * Sets new 账号是否可用.
     *
     * @param enabled New value of 账号是否可用.
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets 密码.
     *
     * @return Value of 密码.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets 账号是否锁定.
     *
     * @return Value of 账号是否锁定.
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * Sets new 密码是否过期.
     *
     * @param passwordExpired New value of 密码是否过期.
     */
    public void setPasswordExpired(Integer passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    /**
     * Sets new 随机盐.
     *
     * @param randomSalt New value of 随机盐.
     */
    public void setRandomSalt(String randomSalt) {
        this.randomSalt = randomSalt;
    }

    /**
     * Sets new 是否系统账户.
     *
     * @param system New value of 是否系统账户.
     */
    public void setSystem(Integer system) {
        this.system = system;
    }

    /**
     * Gets 用户名.
     *
     * @return Value of 用户名.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets 密码过期时间.
     *
     * @return Value of 密码过期时间.
     */
    public Date getPwExpiredTime() {
        return pwExpiredTime;
    }

    /**
     * Sets new 密码过期时间.
     *
     * @param pwExpiredTime New value of 密码过期时间.
     */
    public void setPwExpiredTime(Date pwExpiredTime) {
        this.pwExpiredTime = pwExpiredTime;
    }

    /**
     * Sets new 账号是否过期.
     *
     * @param expired New value of 账号是否过期.
     */
    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    /**
     * Sets new 会员基础ID.
     *
     * @param partyId New value of 会员基础ID.
     */
    public void setPartyId(BigInteger partyId) {
        this.partyId = partyId;
    }

    /**
     * Sets new 密码.
     *
     * @param password New value of 密码.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets 是否注册完成.
     *
     * @return Value of 是否注册完成.
     */
    public Integer getHadSingup() {
        return hadSingup;
    }

    /**
     * Sets new 更新时间.
     *
     * @param updateTime New value of 更新时间.
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Sets new 组织ID.
     *
     * @param partyGroupId New value of 组织ID.
     */
    public void setPartyGroupId(BigInteger partyGroupId) {
        this.partyGroupId = partyGroupId;
    }

    /**
     * Gets 会员基础ID.
     *
     * @return Value of 会员基础ID.
     */
    public BigInteger getPartyId() {
        return partyId;
    }

    /**
     * Sets new 创建时间.
     *
     * @param createTime New value of 创建时间.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Sets new 账号是否锁定.
     *
     * @param locked New value of 账号是否锁定.
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * Gets 密码是否过期.
     *
     * @return Value of 密码是否过期.
     */
    public Integer getPasswordExpired() {
        return passwordExpired;
    }

    /**
     * Gets 随机盐.
     *
     * @return Value of 随机盐.
     */
    public String getRandomSalt() {
        return randomSalt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MemUserLoginPo{");
        sb.append("userLoginId=").append(userLoginId);
        sb.append(", partyId=").append(partyId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", randomSalt='").append(randomSalt).append('\'');
        sb.append(", system=").append(system);
        sb.append(", hadSingup=").append(hadSingup);
        sb.append(", enabled=").append(enabled);
        sb.append(", locked=").append(locked);
        sb.append(", expired=").append(expired);
        sb.append(", passwordExpired=").append(passwordExpired);
        sb.append(", pwExpiredTime=").append(pwExpiredTime);
        sb.append(", partyGroupId=").append(partyGroupId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }


    /**
     * Gets 会员个人信息.
     *
     * @return Value of 会员个人信息.
     */
    public MemPersonPo getMemPersonPo() {
        return memPersonPo;
    }

    /**
     * Sets new 会员个人信息.
     *
     * @param memPersonPo New value of 会员个人信息.
     */
    public void setMemPersonPo(MemPersonPo memPersonPo) {
        this.memPersonPo = memPersonPo;
    }

    /**
     * Sets new 邀请码，注册时候才会用到.
     *
     * @param inviteCode New value of 邀请码，注册时候才会用到.
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    /**
     * Gets 邀请码，注册时候才会用到.
     *
     * @return Value of 邀请码，注册时候才会用到.
     */
    public String getInviteCode() {
        return inviteCode;
    }

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}