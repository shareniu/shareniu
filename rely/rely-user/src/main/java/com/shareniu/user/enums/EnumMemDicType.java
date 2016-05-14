package com.shareniu.user.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据字典类型
 *
 * Created by wzy on 2015/4/28.
 */
public enum EnumMemDicType {
    LEVEL_LIMIT(100, "等级限额"),
    INVITE_OPEN_TIME(101, "邀请码开放时间"),
    USER_DISCOUNT_RATE(102, "会员折扣率"),
    INVITE_USE(103, "邀请码使用设置"),
    USER_DISCOUNT_AMOUNT(104, "会员价格"),
    REGISTER_GAVE_COUPON(105, "注册送券")
    ;

    /**
     * 编码
     */
    private int code;

    /**
     * 值
     */
    private String lebel;

    EnumMemDicType(int code, String label) {
        this.code = code;
        this.lebel = label;
    }

    /**
     * 比较
     *
     * @param code 编码
     * @return boolean
     */
    public boolean compare(int code) {
        return this.code == code;
    }


    /**
     * Gets 编码.
     *
     * @return Value of 编码.
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets 值.
     *
     * @return Value of 值.
     */
    public String getLebel() {
        return lebel;
    }

    /**
     * Sets new 编码.
     *
     * @param code New value of 编码.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Sets new 值.
     *
     * @param lebel New value of 值.
     */
    public void setLebel(String lebel) {
        this.lebel = lebel;
    }

    private static final Map<Integer, String> enumDataMap = new HashMap<Integer, String>();

    public static Map<Integer, String> toMap() {
        if (enumDataMap.size() == 0 && values().length > 0) {
            for (EnumMemDicType attrValType : values()) {
                enumDataMap.put(attrValType.getCode(), attrValType.getLebel());
            }
        }

        return enumDataMap;
    }
}
