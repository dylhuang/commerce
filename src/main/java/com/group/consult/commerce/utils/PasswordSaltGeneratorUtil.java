package com.group.consult.commerce.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * 密码处理工具类
 */
public class PasswordSaltGeneratorUtil {
    /**
     * 盐值长度
     */
    private static final int SALT_LEN = 10;

    public static String encode(String password) {
        String randSalt = randomSalt();
        return randSalt + saltPwd(password, randSalt);
    }


    /**
     *  密码加盐
     * @param password
     * @param salt
     * @return
     */
    private static String saltPwd(String password, String salt) {
        return SecureUtil.hmacMd5(password + salt).digestHex(salt);
    }

    /**
     * 密码匹配
     * @param password  原始密码，非加密
     * @param dbPwd
     * @return
     */
    public static boolean match(String password, String dbPwd) {
        String salt = dbPwd.substring(0, SALT_LEN);
        String dbRawPwd = dbPwd.substring(SALT_LEN);
        return saltPwd(password, salt).equals(dbRawPwd);
    }

    /**
     * 随机盐值
     * @return
     */
    private static String randomSalt() {
        return RandomUtil.randomString(SALT_LEN);
    }

    /**
     * 示例用法
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        try {
            String pwd = "123434";
            System.out.println(encode(pwd));
            System.out.println(encode(pwd));
            String pwdAf = encode(pwd);
            System.out.println("==" + pwdAf);
            System.out.println(match(pwd, pwdAf));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
