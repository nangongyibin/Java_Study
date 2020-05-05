package com.ngyb.study.constant;

public interface Constants {
    /**
     * 成功
     */
    public static final int CODE_SUCCESS = 0;
    /**
     * 注册失败
     */
    public static final int CODE_REGISTER_FAILED = -101;
    /**
     * 服务器异常
     */
    public static final int CODE_REMOTE_ERROR = -200;
    /**
     * 参数
     */
    public static final int CODE_PARAM_ERROR = -201;
    /**
     * 登录超时
     */
    public static final int CODE_LOGIN_EXPIRED = -202;
    /**
     * 没有传入用户名参数
     */
    public static final int CODE_NOT_INPUT_USER = -301;
    /**
     * 没有传入用户密码参数
     */
    public static final int CODE_NOT_INPUT_PASSWORD = -302;
    /**
     * 用户名错误
     */
    public static final int CODE_USERNAME_INCORRECT = -303;
    /**
     * 用户密码错误
     */
    public static final int CODE_PASSWORD_INCORRECT = -304;
    public static final int CODE_MISSING_SIGN = -305;
    /**
     * RSA签名校验失败
     */
    public static final int CODE_RSA_SIGN_ERROR = -306;
    /**
     * url失效
     */
    public static final int CODE_URL_EXPIRED = -307;
    /******************key**************************/
    public static final String KEY_MSG = "msg";
    public static final String KEY_CODE = "code";
    public static final String KEY_EXPIRED = "expired";
}
