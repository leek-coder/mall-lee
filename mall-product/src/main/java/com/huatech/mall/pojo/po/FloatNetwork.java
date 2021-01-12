package com.huatech.mall.pojo.po;

import java.io.Serializable;

/**
 * @author like
 * @date 2020-09-09 10:32 上午
 **/
public class FloatNetwork implements Serializable {

    /**
     * 外部网络
     */
    private String externalNetwork;
    /**
     * 子网
     */
    private String subnet;

    /**
     * 带宽类型   独享带宽&&共享带宽
     */
    private String bandwidthType;

    /**
     * 带宽大小：独享带宽不为空
     */

    private Integer capacity;
    /**
     * 带宽名称
     */
    private String bandwidthId;


    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getBandwidthType() {
        return bandwidthType;
    }

    public void setBandwidthType(String bandwidthType) {
        this.bandwidthType = bandwidthType;
    }


    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getBandwidthId() {
        return bandwidthId;
    }

    public void setBandwidthId(String bandwidthId) {
        this.bandwidthId = bandwidthId;
    }


    public String getExternalNetwork() {
        return externalNetwork;
    }

    public void setExternalNetwork(String externalNetwork) {
        this.externalNetwork = externalNetwork;
    }

    @Override
    public String toString() {
        return "FloatNetwork{" +
                "networkType='" + externalNetwork + '\'' +
                ", subnet='" + subnet + '\'' +
                ", bandwidthType='" + bandwidthType + '\'' +
                ", capacity=" + capacity +
                ", bandwidthId='" + bandwidthId + '\'' +
                '}';
    }
}