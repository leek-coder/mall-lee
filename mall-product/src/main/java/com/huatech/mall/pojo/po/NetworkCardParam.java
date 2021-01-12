package com.huatech.mall.pojo.po;

import java.io.Serializable;

/**
 * vmWare网卡创建
 *
 * @author like
 * @date 2020-12-21 10:29 上午
 **/
public class NetworkCardParam implements Serializable {

    /**
     * 交换网络id
     */
    private String vpcId;

    /**
     * 交换网络名称
     */
    private String vpcName;

    /**
     * 打开电源时链接
     */
    private Boolean linkAfterPowerOn;


    /**
     * mac地址类型  1：自定 2：手动
     */
    private Integer addressType;

    /**
     * mac地址
     */
    private String macAddress;

    /**
     * 绑定ip地址  1：是  2：否
     */
    private Integer bindIp;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 网关
     */
    private String gateway;

    /**
     * mask
     */
    private String mask;

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    public Boolean getLinkAfterPowerOn() {
        return linkAfterPowerOn;
    }

    public void setLinkAfterPowerOn(Boolean linkAfterPowerOn) {
        this.linkAfterPowerOn = linkAfterPowerOn;
    }


    public Integer getBindIp() {
        return bindIp;
    }

    public void setBindIp(Integer bindIp) {
        this.bindIp = bindIp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getVpcName() {
        return vpcName;
    }

    public void setVpcName(String vpcName) {
        this.vpcName = vpcName;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }
}