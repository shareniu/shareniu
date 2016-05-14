package com.shareniu.user.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 会员的保底级别
 *
 * Created by wzy on 2015/6/7.
 */
public enum  EnumPersonAttr {
    baseLevel("baseLevel");
    private String code;

    EnumPersonAttr(String code) {
        this.code = code;
    }

    public boolean compare(String code) {
        return !StringUtils.isEmpty(code) && this.code.equals(code);
    }


    /**
     * Gets code.
     *
     * @return Value of code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets new code.
     *
     * @param code New value of code.
     */
    public void setCode(String code) {
        this.code = code;
    }
}
