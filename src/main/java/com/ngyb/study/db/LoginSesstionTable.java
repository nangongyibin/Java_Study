package com.ngyb.study.db;

/**
 * 用户登录信息数据表
 */
public interface LoginSesstionTable {
    public static String TABLE_NAME = "login_session";
    public static String COLUMN_USER_ID = "user_id";
    public static String COLUMN_TOKEN = "token";
    public static String COLUMN_TIMESTAMP = "timestamp";
}
