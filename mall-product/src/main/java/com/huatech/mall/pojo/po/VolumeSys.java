package com.huatech.mall.pojo.po;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统盘
 *
 * @author like
 * @date 2020-09-09 9:57 上午
 **/
public class VolumeSys implements Serializable {

    /**
     * 容量大小
     */
    private Integer capacity;

    /**
     * 系统盘类型
     */
    @NotBlank(message = "请选择系统盘类型")
    private String type;

    /**
     * 磁盘规格产品id
     */
    @NotBlank(message = "请输入系统盘产品")
    private String productId;

    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}