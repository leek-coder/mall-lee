package com.huatech.mall.pojo.po;


import java.io.Serializable;

/**
 * @author like
 * @date 2020-09-01 5:15 下午
 **/
public class VolumeData implements Serializable {


    /**
     * 容量大小
     */
    private Long capacity;

    /**
     * 数据盘类型
     */
    private String type;

    /**
     * 数据盘产品id
     */
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 是否支持SCSI 0：不支持  1：支持
     */
    private Integer scsi;

    private Integer sort;

    /**
     * 磁盘模式
     */
    private String volumeMode;

    /**
     * 是否共享盘
     */
    private Integer share;


    public String getVolumeMode() {
        return volumeMode;
    }

    public void setVolumeMode(String volumeMode) {
        this.volumeMode = volumeMode;
    }


    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getScsi() {
        return scsi;
    }

    public void setScsi(Integer scsi) {
        this.scsi = scsi;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VolumeData{" +
                "capacity=" + capacity +
                ", type='" + type + '\'' +
                ", productId='" + productId + '\'' +
                ", scsi=" + scsi +
                ", sort=" + sort +
                ", volumeMode='" + volumeMode + '\'' +
                ", isShare=" + share +
                '}';
    }
}