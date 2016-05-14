package com.shareniu.user.po;


import java.math.BigInteger;
import java.util.Date;

/**
 * 会员基础 Po
 *
 * @author wzy
 * @since 1.0
 */
public class MemPartyPo{
    private static final long serialVersionUID = 4194306514756045593L;
    /**
     * 会员基础ID
     */
    private BigInteger partyId;
    /**
     * 外部ID
     */
    private String externalId;
    /**
     * 会员类型 数据范围 0-255
     * 100：person
     */
    private Integer partyType;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * Sets new 外部ID.
     *
     * @param externalId New value of 外部ID.
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
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
     * Gets 更新时间.
     *
     * @return Value of 更新时间.
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * Gets 外部ID.
     *
     * @return Value of 外部ID.
     */
    public String getExternalId() {
        return externalId;
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
     * Sets new 会员基础ID.
     *
     * @param partyId New value of 会员基础ID.
     */
    public void setPartyId(BigInteger partyId) {
        this.partyId = partyId;
    }

    /**
     * Sets new 会员类型 数据范围 0-255
     * 100：person.
     *
     * @param partyType New value of 会员类型 数据范围 0-255
     *                  100：person.
     */
    public void setPartyType(Integer partyType) {
        this.partyType = partyType;
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
     * Gets 描述.
     *
     * @return Value of 描述.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets 会员类型 数据范围 0-255
     * 100：person.
     *
     * @return Value of 会员类型 数据范围 0-255
     * 100：person.
     */
    public Integer getPartyType() {
        return partyType;
    }

    /**
     * Sets new 描述.
     *
     * @param description New value of 描述.
     */
    public void setDescription(String description) {
        this.description = description;
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
        final StringBuilder sb = new StringBuilder("MemPartyPo{");
        sb.append("partyId=").append(partyId);
        sb.append(", externalId='").append(externalId).append('\'');
        sb.append(", partyType=").append(partyType);
        sb.append(", description='").append(description).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}