package com.huatech.mall.pojo.vo;

import java.io.Serializable;

/**
 * @author like
 * @date 2020-11-24 8:43 下午
 **/
public class ProjectTenant implements Serializable {

    private Long id;
    private String projectName;

    /**
     * 主租户信息
     */
    private MasterTenant masterTenant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public MasterTenant getMasterTenant() {
        return masterTenant;
    }

    public void setMasterTenant(MasterTenant masterTenant) {
        this.masterTenant = masterTenant;
    }
}