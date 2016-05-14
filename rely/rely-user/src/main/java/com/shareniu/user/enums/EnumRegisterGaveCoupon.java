package com.shareniu.user.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 邀请码使用设置
 *
 * Created by wzy on 2015/4/28.
 */
public enum EnumRegisterGaveCoupon {
    INVITE_USER("inviteUser", "邀请人送券"),
    REGISTER_USER("registerUser", "注册人送券");

    /**
     * 编码
     */
    private String code;

    /**
     * 值
     */
    private String lebel;

    EnumRegisterGaveCoupon(String code, String label) {
        this.code = code;
        this.lebel = label;
    }

    /**
     * 比较
     *
     * @param code 编码
     * @return boolean
     */
    public boolean compare(String code) {
        return code != null && this.code.equals(code);

    }


    /**
     * Gets 编码.
     *
     * @return Value of 编码.
     */
    public String getCode() {
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
    public void setCode(String code) {
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

    private static final Map<String, String> enumDataMap = new HashMap<String, String>();

    public static Map<String, String> toMap() {
        if (enumDataMap.size() == 0 && values().length > 0) {
            for (EnumRegisterGaveCoupon attrValType : values()) {
                enumDataMap.put(attrValType.getCode(), attrValType.getLebel());
            }
        }

        return enumDataMap;
    }
}
