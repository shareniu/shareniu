package com.shareniu.user.po;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * MemPersonPo Po
 *
 * @author system
 */
public class MemPersonPo extends MemPartyPo {
    private static final long serialVersionUID = 9191140066283466533L;
    /**
     * 人员ID
     */
    private BigInteger partyId;
    /**
     * 地理位置
     */
    private String region;
    /**
     * 用户等级
     */
    private Integer personLevel;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 生日
     */
    private Date birthDate;
    /**
     * 性别
     */
    private String gender;
    /**
     * 是否有表
     */
    private Integer hasTable;
    /**
     * 个人主页地址
     */
    private String homePage;
    /**
     * 头像地址
     */
    private String imgUrl;
    /**
     * 默认头像地址
     */
    private String defaultImgUrl;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 会员扩展信息
     */
    private List<MemPersonAttrPo> personAttrPoList;

    /**
     * Gets 创建时间.
     *
     * @return Value of 创建时间.
     */
    public Date getCreateTime() {
        return createTime;
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
     * Gets 是否有表.
     *
     * @return Value of 是否有表.
     */
    public Integer getHasTable() {
        return hasTable;
    }

    /**
     * Sets new 生日.
     *
     * @param birthDate New value of 生日.
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
     * Gets 人员ID.
     *
     * @return Value of 人员ID.
     */
    public BigInteger getPartyId() {
        return partyId;
    }

    /**
     * Sets new 真实姓名.
     *
     * @param realName New value of 真实姓名.
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * Sets new 人员ID.
     *
     * @param partyId New value of 人员ID.
     */
    public void setPartyId(BigInteger partyId) {
        this.partyId = partyId;
    }

    /**
     * Gets 真实姓名.
     *
     * @return Value of 真实姓名.
     */
    public String getRealName() {
        return realName;
    }

    /**
     * Gets 地理位置.
     *
     * @return Value of 地理位置.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets new 是否有表.
     *
     * @param hasTable New value of 是否有表.
     */
    public void setHasTable(Integer hasTable) {
        this.hasTable = hasTable;
    }

    /**
     * Gets 昵称.
     *
     * @return Value of 昵称.
     */
    public String getNickname() {
        return nickname;
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
     * Gets 性别.
     *
     * @return Value of 性别.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets new 个人主页地址.
     *
     * @param homePage New value of 个人主页地址.
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    /**
     * Gets 默认头像地址.
     *
     * @return Value of 默认头像地址.
     */
    public String getDefaultImgUrl() {
        return defaultImgUrl;
    }

    /**
     * Gets 生日.
     *
     * @return Value of 生日.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Gets 头像地址.
     *
     * @return Value of 头像地址.
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Sets new 性别.
     *
     * @param gender New value of 性别.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets 个人主页地址.
     *
     * @return Value of 个人主页地址.
     */
    public String getHomePage() {
        return homePage;
    }

    /**
     * Gets 用户等级.
     *
     * @return Value of 用户等级.
     */
    public Integer getPersonLevel() {
        return personLevel;
    }

    /**
     * Sets new 头像地址.
     *
     * @param imgUrl New value of 头像地址.
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * Sets new 地理位置.
     *
     * @param region New value of 地理位置.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Sets new 昵称.
     *
     * @param nickname New value of 昵称.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Sets new 默认头像地址.
     *
     * @param defaultImgUrl New value of 默认头像地址.
     */
    public void setDefaultImgUrl(String defaultImgUrl) {
        this.defaultImgUrl = defaultImgUrl;
    }

    /**
     * Sets new 用户等级.
     *
     * @param personLevel New value of 用户等级.
     */
    public void setPersonLevel(Integer personLevel) {
        this.personLevel = personLevel;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("MemPersonPo{");
        sb.append("partyId=").append(partyId);
        sb.append(", region='").append(region).append('\'');
        sb.append(", personLevel=").append(personLevel);
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", hasTable=").append(hasTable);
        sb.append(", homePage='").append(homePage).append('\'');
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", defaultImgUrl='").append(defaultImgUrl).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }

    /**
     * Gets 会员扩展信息.
     *
     * @return Value of 会员扩展信息.
     */
    public List<MemPersonAttrPo> getPersonAttrPoList() {
        return personAttrPoList;
    }

    /**
     * Sets new 会员扩展信息.
     *
     * @param personAttrPoList New value of 会员扩展信息.
     */
    public void setPersonAttrPoList(List<MemPersonAttrPo> personAttrPoList) {
        this.personAttrPoList = personAttrPoList;
    }
}