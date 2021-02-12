package com.huatech.mall.response;


import com.huatech.mall.enums.ApiErrorCodeEnum;

import java.io.Serializable;

/**
 * @ClassName ResponseResult
 * @Description TODO
 * @Author like
 * @Date 2019-12-08 12:13
 * @Version 1.0
 **/
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -1491499610244557029L;
    /**
     * 成功状态码200
     */
    public static int CODE_SUCCESS = 200;
    /**
     * 失败状态码 500
     */
    public static int CODE_FAIL = 500;

    /**
     * 处理状态：200: 成功
     */
    private int code;
    private String message;

    public ResponseResult() {
    }

    /**
     * 返回数据
     */
    private T data = null;

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 处理成功
     * 消息
     *
     * @return data
     */
    public static final ResponseResult success() {
        return new ResponseResult(CODE_SUCCESS, "成功", null);
    }

    /**
     * 处理成功
     *
     * @param message 消息
     * @return data
     */
    public static final ResponseResult success(String message) {
        return new ResponseResult(CODE_SUCCESS, message, null);
    }

    /**
     * 处理成功
     *
     * @param data 数据对象
     * @return data
     */
    public static final ResponseResult success(Object data) {
        return new ResponseResult(CODE_SUCCESS, "成功", data);
    }

    /**
     * 处理失败，并返回数据（一般为错误信息）
     *
     * @param code    错误代码
     * @param message 消息
     * @return data
     */
    public static final ResponseResult failure(int code, String message, int errorCode) {
        return new ResponseResult(code, message, null);
    }

    public static final ResponseResult failure(int code, String message) {
        return new ResponseResult(code, message, null);
    }

    /**
     * 处理失败
     *
     * @param message 消息
     * @return data
     */
    public static final ResponseResult failure(String message, int errorCode) {
        return failure(CODE_FAIL, message, errorCode);
    }

    public static final ResponseResult failure(ApiErrorCodeEnum errorCode) {
        return failure(CODE_FAIL, errorCode.message(), errorCode.code());
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
