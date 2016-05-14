package com.shareniu.mall.shiro.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * 密码工具类
 *
 * Created by wenzhouyang on 2014/8/30.
 */
public class PasswordUtils {

    private static String hashAlgorithm = "MD5";

    private static int hashIterations = 2;

    private static boolean storedCredentialsHexEncoded = true;

    private static int defaultLength = 8;

    /**
     * 密码加密
     *
     * @param password 明文密码
     * @param salt 盐
     * @return 密文
     */
    public static String hashProvidedCredentials(String password, String salt) {
        SimpleHash simpleHash = new SimpleHash(hashAlgorithm, password, salt, hashIterations);
        if (storedCredentialsHexEncoded) {
            return simpleHash.toHex();
        } else {
            return simpleHash.toBase64();
        }
    }

    /**
     * 获取密码盐
     *
     * @return 盐
     */
    public static String getSalt() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取随机密码
     * default length = 8;
     * @return 密码
     */
    public static String getRandomPassword() {
        return getRandomPassword(defaultLength);
    }

    /**
     * 获取随机密码
     *
     * @param length 密码长度
     * @return 密码
     */
    public static String getRandomPassword(int length) {
        if (length < 1) {
            length = defaultLength;
        }
        return RandomStringUtils.random(length, true, true);
    }


    /**
     * Gets hashIterations.
     *
     * @return Value of hashIterations.
     */
    public static int getHashIterations() {
        return hashIterations;
    }

    /**
     * Gets storedCredentialsHexEncoded.
     *
     * @return Value of storedCredentialsHexEncoded.
     */
    public static boolean isStoredCredentialsHexEncoded() {
        return storedCredentialsHexEncoded;
    }

    /**
     * Sets new hashAlgorithm.
     *
     * @param hashAlgorithm New value of hashAlgorithm.
     */
    public static void setHashAlgorithm(String hashAlgorithm) {
        hashAlgorithm = hashAlgorithm;
    }

    /**
     * Sets new storedCredentialsHexEncoded.
     *
     * @param storedCredentialsHexEncoded New value of storedCredentialsHexEncoded.
     */
    public static void setStoredCredentialsHexEncoded(boolean storedCredentialsHexEncoded) {
        storedCredentialsHexEncoded = storedCredentialsHexEncoded;
    }

    /**
     * Gets hashAlgorithm.
     *
     * @return Value of hashAlgorithm.
     */
    public static String getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * Sets new hashIterations.
     *
     * @param hashIterations New value of hashIterations.
     */
    public static void setHashIterations(int hashIterations) {
        hashIterations = hashIterations;
    }
}
