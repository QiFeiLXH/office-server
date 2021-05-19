package com.bsoft.office.common.response;

public class OfficeResponseCode {
    /**
     * 用户名、密码验证错误
     */
    public static final Integer VALIDATION_ERROR = 10001;

    /**
     * 登录超时
     */
    public static final Integer LOGIN_TIMEOUT = 10002;

    /**
     * 单点登录失败
     */
    public static final Integer OAUTH_LOGIN_ERROR = 10003;

    /**
     * 验证码错误
     */
    public static final Integer VERIFY_CODE_ERROR = 10004;

    /**
     * 参数异常
     */
    public static final Integer PARAM_EXCEPTION = 90001;
}
