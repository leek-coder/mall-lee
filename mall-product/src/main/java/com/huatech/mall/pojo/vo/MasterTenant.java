package com.huatech.mall.pojo.vo;

import java.util.List;

/**
 * 主租户信息
 *
 * @author like
 * @date 2020-11-25 9:43 上午
 **/
public class MasterTenant {
    /**
     * 主租户名称
     */
    private String masterTenantName;
    /**
     * 主租户编码
     */
    private String masterTenantCode;
    private String masterTenantId;

    /**
     * 租户列表
     */
    private List<Tenant> tenantList;

    public String getMasterTenantName() {
        return masterTenantName;
    }

    public void setMasterTenantName(String masterTenantName) {
        this.masterTenantName = masterTenantName;
    }

    public String getMasterTenantCode() {
        return masterTenantCode;
    }

    public void setMasterTenantCode(String masterTenantCode) {
        this.masterTenantCode = masterTenantCode;
    }

    public String getMasterTenantId() {
        return masterTenantId;
    }

    public void setMasterTenantId(String masterTenantId) {
        this.masterTenantId = masterTenantId;
    }

    public List<Tenant> getTenantList() {
        return tenantList;
    }

    public void setTenantList(List<Tenant> tenantList) {
        this.tenantList = tenantList;
    }
}