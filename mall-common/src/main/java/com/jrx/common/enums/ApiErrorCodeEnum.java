package com.jrx.common.enums;

/**
 * 返回前端错误码枚举
 *
 * @author like
 * @date 2020-08-20 8:07 下午
 **/
public enum ApiErrorCodeEnum {
    // ****************** 通用错误码，以1开头 **********************
    ERROR_UNKNOWN(1000, "未知错误"),
    ERROR_TYPE_CONVERSION(1100, "实例构建异常"),
    ERROR_NOT_EXIST_BIND_ROUTER_EXTERNAL_NETWORK(1101, "云商下无绑定路由的外部网络"),
    ERROR_NOT_CHECK_BIND_ROUTER_EXTERNAL_NETWORK(1102, "子网关联路由无外部网络信息"),
    ERROR_CLOUD_ID_FORMAT(1001, "云服务商ID参数错误"),
    ERROR_CLOUD_NOT_EXIST(1002, "云服务商不存在"),
    ERROR_BUILD_INDEX_FAIL(1003, "构建索引库失败"),
    USER_NOT_EXISTS(1004,"用户不存在"),
    USER_EXISTS(1005,"用户已存在"),
    PASSWORD_ERROR(2002,"密码错误" ),
    UNAUTHORIZED(401, "未认证，签名错误"),
    TOKEN_FAIL(4000, "Token验证失败"),
    TOKEN_IS_EXPIRED(4001, "Token已过期"),
    TOKEN_IS_VALID(4002, "Token不合法"),
    REMOTE_SERVICE_FAIL(5000, "远程服务调用失败"),
    JSON_TRANS_ERROR(5001, "参数转化异常"),
    AUTH_REMOTE_FAIL(5002, "远程调用鉴权服务失败"),
    ;
    private Integer code;
    private String message;

    ApiErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessageByCode(int code) {
        ApiErrorCodeEnum[] apiErrorCodeEnums = ApiErrorCodeEnum.values();
        for (ApiErrorCodeEnum apiErrorCodeEnum : apiErrorCodeEnums) {
            if (apiErrorCodeEnum.code() == code) {
                return apiErrorCodeEnum.message;
            }
        }
        return null;
    }

    public static ApiErrorCodeEnum getApiError(int code) {
        ApiErrorCodeEnum[] apiErrorCodeEnums = ApiErrorCodeEnum.values();
        for (ApiErrorCodeEnum apiErrorCodeEnum : apiErrorCodeEnums) {
            if (apiErrorCodeEnum.code() == code) {
                return apiErrorCodeEnum;
            }
        }
        return ApiErrorCodeEnum.ERROR_UNKNOWN;
    }
}