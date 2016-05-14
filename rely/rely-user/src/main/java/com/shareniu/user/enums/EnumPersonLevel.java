package com.shareniu.user.enums;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 会员等级
 *
 * Created by wzy on 2015/4/28.
 */
public enum EnumPersonLevel {
    A(10, "VIP尊享"),
    B(9, "VIP钻石"),
    C(8, "VIP白金"),
    D(7, "VIP普通"),
    ;

    /**
     * 编码
     */
    private int code;

    /**
     * 值
     */
    private String lebel;

    EnumPersonLevel(int code, String label) {
        this.code = code;
        this.lebel = label;
    }

    public int next() {
        EnumPersonLevel[] levels = values();

        int code = 0;

        for (EnumPersonLevel level : levels) {
            if (this.getCode() + 1 == level.getCode()) {
                //当前的值
                code = level.getCode();
            }
        }

        if (code == 0) {
            code = levels[levels.length - 1].getCode();
        }

        if (code == 0) {
            throw new NullPointerException();
        }

        return code;
    }

    public int pre() {
        EnumPersonLevel[] levels = values();

        int code = 0;

        for (EnumPersonLevel level : levels) {
            if (this.getCode() - 1 == level.getCode()) {
                //当前的值
                code = level.getCode();
            }
        }

        if (code == 0) {
            code = levels[levels.length - 1].getCode();
        }

        if (code == 0) {
            throw new NullPointerException();
        }

        return code;
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

    public static EnumPersonLevel valueOf(int code) {
        for (EnumPersonLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        throw new NullPointerException("不存在的用户级别");
    }

    private static final Map<Integer, String> enumDataMap = new HashMap<Integer, String>();
    private static final Map<String, String> enumDataStrMap = new LinkedHashMap<String, String>();
    public static Map<Integer, String> toMap() {
        if (enumDataMap.size() == 0 && values().length > 0) {
            for (EnumPersonLevel attrValType : values()) {
                enumDataMap.put(attrValType.getCode(), attrValType.getLebel());
            }
        }

        return enumDataMap;
    }

    public static Map<String, String> toStrMap() {
        if (enumDataStrMap.size() == 0 && values().length > 0) {
            for (EnumPersonLevel attrValType : values()) {
                enumDataStrMap.put(String.valueOf(attrValType.getCode()), attrValType.getLebel());
            }
        }

        return enumDataStrMap;
    }
}
