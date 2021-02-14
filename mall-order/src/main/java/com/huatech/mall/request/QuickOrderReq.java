package com.huatech.mall.request;

import java.io.Serializable;

/**
 * 秒杀下单实体
 *
 * @author like
 * @date 2020-06-23 12:38 上午
 **/
public class QuickOrderReq implements Serializable {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 用户id
     */
    private Long userId;

    private  String token;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "QuickOrderReq{" +
                "productId='" + productId + '\'' +
                ", userId=" + userId +
                '}';
    }
}