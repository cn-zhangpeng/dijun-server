package com.zp95sky.dijun.common.constant;

/**
 * 响应码
 */
public class ErrorConstant {

    private ErrorConstant() { }

    // 项目相关
    public static final String PROJECT_NOT_EXIST = "P00001";

    // 用户相关
    public static final String USER_EMAIL_OR_PASSWORD = "U00001";

    // 通用错误
    public static final String COMMON_INTERNAL_SERVER_ERROR = "C00001";
    public static final String COMMON_TOKEN_INVALID = "C00401";

}
