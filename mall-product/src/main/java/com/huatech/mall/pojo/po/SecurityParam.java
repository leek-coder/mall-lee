package com.huatech.mall.pojo.po;

import java.io.Serializable;

/**
 * 安全组入参
 *
 * @author like
 * @date 2020-09-09 10:21 上午
 **/
public class SecurityParam implements Serializable {

    /**
     * 安全组是否默认  1：默认 0：选择
     */
    private Integer defaultSecurity;

    /**
     * 安全组id
     */
    private Long securityGroupId;

    public Integer getDefaultSecurity() {
        return defaultSecurity;
    }

    public void setDefaultSecurity(Integer defaultSecurity) {
        this.defaultSecurity = defaultSecurity;
    }

    public Long getSecurityGroupId() {
        return securityGroupId;
    }

    public void setSecurityGroupId(Long securityGroupId) {
        this.securityGroupId = securityGroupId;
    }

    @Override
    public String toString() {
        return "SecurityParam{" +
                "defaultSecurity=" + defaultSecurity +
                ", securityGroupId='" + securityGroupId + '\'' +
                '}';
    }
}