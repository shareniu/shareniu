package com.shareniu.user.po;

import java.math.BigInteger;
import java.util.Date;

/**
 * 人员 Po
 *
 * @author wzy
 * @since 1.0
 */
public class MemPersonAttrPo{
    private static final long serialVersionUID = 7868899467126061303L;
    /**
     * 人员ID
     */
    private BigInteger partyId;
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 属性值
     */
    private String attrValue;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * Gets 属性名.
     *
     * @return Value of 属性名.
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * Gets 属性值.
     *
     * @return Value of 属性值.
     */
    public String getAttrValue() {
        return attrValue;
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
     * Gets 创建时间.
     *
     * @return Value of 创建时间.
     */
    public Date getCreateTime() {
        return createTime;
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
     * Gets 更新时间.
     *
     * @return Value of 更新时间.
     */
    public Date getUpdateTime() {
        return updateTime;
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
     * Sets new 属性名.
     *
     * @param attrName New value of 属性名.
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     * Sets new 属性值.
     *
     * @param attrValue New value of 属性值.
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    /**
     * Sets new 更新时间.
     *
     * @param updateTime New value of 更新时间.
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MemPersonAttrPo{");
        sb.append("partyId=").append(partyId);
        sb.append(", attrName='").append(attrName).append('\'');
        sb.append(", attrValue='").append(attrValue).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}