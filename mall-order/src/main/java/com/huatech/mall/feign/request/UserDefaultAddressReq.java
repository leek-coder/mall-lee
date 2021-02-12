package com.huatech.mall.feign.request;

import java.io.Serializable;

/**
 * @author like
 * @date 2020-06-23 11:09 上午
 **/
public class UserDefaultAddressReq implements Serializable {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDefaultAddressReq{" +
                "userId='" + userId + '\'' +
                '}';
    }
}