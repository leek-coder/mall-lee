package com.huatech.mall.pojo.vo;

import java.io.Serializable;

/**
 * 租户
 *
 * @author like
 * @date 2020-11-25 9:52 上午
 **/
public class Tenant implements Serializable {

    /**
     * 租户id
     */
    private Long id;
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 资源池
     */
    private Long regionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
}