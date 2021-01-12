package com.huatech.mall.model;


import java.io.Serializable;
import java.util.Date;

/**
 * @author like
 * @date 2019-11-28 4:48 下午
 */
public class UcsSubscription implements Serializable {
    private Long id;

    private Long instanceId;

    private String instanceName;

    private String status;

    private Integer serviceType;

    private Integer serviceStatus;

    private String uuid;

    private Date createTime;

    private Date activeTime;

    private Date inactiveTime;

    private Date lastStatusChgTime;

    private String optStatus;

    private Date optStatusChgTime;

    private Long regionId;

    private String regionName;

    private String regionCode;

    private String azId;

    private String azName;

    private String azCode;

    private String userId;

    private String userName;

    private String tenantId;

    private Long projectId;

    private Long cloudId;

    private String cloudName;

    private String cloudCode;

    private String cloudType;

    /**
     * 主账号租户id
     */
    private String masterTenantId;

    public String getMasterTenantId() {
        return masterTenantId;
    }

    public void setMasterTenantId(String masterTenantId) {
        this.masterTenantId = masterTenantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Integer serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Date inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public Date getLastStatusChgTime() {
        return lastStatusChgTime;
    }

    public void setLastStatusChgTime(Date lastStatusChgTime) {
        this.lastStatusChgTime = lastStatusChgTime;
    }

    public String getOptStatus() {
        return optStatus;
    }

    public void setOptStatus(String optStatus) {
        this.optStatus = optStatus;
    }

    public Date getOptStatusChgTime() {
        return optStatusChgTime;
    }

    public void setOptStatusChgTime(Date optStatusChgTime) {
        this.optStatusChgTime = optStatusChgTime;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getAzId() {
        return azId;
    }

    public void setAzId(String azId) {
        this.azId = azId;
    }

    public String getAzName() {
        return azName;
    }

    public void setAzName(String azName) {
        this.azName = azName;
    }

    public String getAzCode() {
        return azCode;
    }

    public void setAzCode(String azCode) {
        this.azCode = azCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getCloudId() {
        return cloudId;
    }

    public void setCloudId(Long cloudId) {
        this.cloudId = cloudId;
    }

    public String getCloudName() {
        return cloudName;
    }

    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    public String getCloudCode() {
        return cloudCode;
    }

    public void setCloudCode(String cloudCode) {
        this.cloudCode = cloudCode;
    }

    public String getCloudType() {
        return cloudType;
    }

    public void setCloudType(String cloudType) {
        this.cloudType = cloudType;
    }
}