package com.huatech.mall.pojo.po;

import java.io.Serializable;

/**
 * 网络入参
 *
 * @author like
 * @date 2020-09-09 10:15 上午
 **/
public class NetworkParam implements Serializable {

    /**
     * 专有网络是否默认 1：默认  0：选择
     */
    private Integer vpcDefault;

    /**
     * 专有网络唯一标示
     */
    private Long vpcId;

    /**
     * vpc产品id
     */
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 子网是否默认： 1：默认  0：选择
     */
    private Integer subnetDefault;


    /**
     * 子网唯一标示
     */
    private Long subnetId;

    public Integer getVpcDefault() {
        return vpcDefault;
    }

    public void setVpcDefault(Integer vpcDefault) {
        this.vpcDefault = vpcDefault;
    }

    public Long getVpcId() {
        return vpcId;
    }

    public void setVpcId(Long vpcId) {
        this.vpcId = vpcId;
    }

    public Integer getSubnetDefault() {
        return subnetDefault;
    }

    public void setSubnetDefault(Integer subnetDefault) {
        this.subnetDefault = subnetDefault;
    }

    public Long getSubnetId() {
        return subnetId;
    }

    public void setSubnetId(Long subnetId) {
        this.subnetId = subnetId;
    }

    @Override
    public String toString() {
        return "NetworkParam{" +
                "vpcDefault=" + vpcDefault +
                ", vpcId='" + vpcId + '\'' +
                ", subnetDefault=" + subnetDefault +
                ", subnetId='" + subnetId + '\'' +
                '}';
    }
}