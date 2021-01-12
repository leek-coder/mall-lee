package com.huatech.mall.pojo.po;

import java.io.Serializable;

/**
 * 弹性公网ip入参
 *
 * @author like
 * @date 2020-09-09 10:27 上午
 **/
public class FloatIpParam implements Serializable {

    /**
     * 弹性公网ip分配类型  0:现在创建，1：使用已有：2：暂不创建
     */
    private Integer accessIpMode;

    /**
     * 弹性公网ip标示  如accessIpMode取值1，floatIp不能为空
     */
    private Long ipId;

    /**
     * 公网产品id
     */
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 外部网络 "ipId":"2130902651876537821"
     */
    private FloatNetwork outNetwork;

    public FloatNetwork getOutNetwork() {
        return outNetwork;
    }

    public void setOutNetwork(FloatNetwork outNetwork) {
        this.outNetwork = outNetwork;
    }

    public Integer getAccessIpMode() {
        return accessIpMode;
    }

    public void setAccessIpMode(Integer accessIpMode) {
        this.accessIpMode = accessIpMode;
    }

    public Long getIpId() {
        return ipId;
    }

    public void setIpId(Long ipId) {
        this.ipId = ipId;
    }

    @Override
    public String toString() {
        return "FloatIpParam{" +
                "accessIpMode=" + accessIpMode +
                ", ipId=" + ipId +
                '}';
    }
}