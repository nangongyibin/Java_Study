package com.ngyb.study.db;

/**
 * 时间设置表
 */
public interface TimeSettingTable {
    public static String TABLE_NAME = "time_setting";
    public static String COLUMN_LOGIN_EXPIRED = "login_expired";
    /**
     * RSA公钥
     */
    public static String COLUMN_PUB_KEY = "rsa_pub_key";
    /**
     * RSA私钥
     */
    public static String COLUMN_PRI_KEY = "rsa_pri_key";
}
