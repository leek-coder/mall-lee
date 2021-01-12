package com.huatech.mall.pojo.vo;

import java.io.Serializable;

/**
 * @author like
 * @date 2020-10-16 2:42 下午
 **/
public class CurrentUser implements Serializable {


    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 资源池
     */
    private Long regionId;
    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 主账号id
     */
    private String masterTenantId;

    public String getMasterTenantId() {
        return masterTenantId;
    }

    public void setMasterTenantId(String masterTenantId) {
        this.masterTenantId = masterTenantId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "projectId=" + projectId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", regionId=" + regionId +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}