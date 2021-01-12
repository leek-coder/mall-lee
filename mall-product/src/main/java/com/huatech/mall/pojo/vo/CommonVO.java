package com.huatech.mall.pojo.vo;

import java.util.List;

public class CommonVO {

    /**
     * 新增属性：云服务商ID
     */
    private Long cloudId;

    private String cloudName;

    private String[] cloudCode;

    private String[] cloudType;

    private String regionName;

    private String[] regionCode;

    private Long regionId;

    /**
     * 新增操作系统类型查询参数
     */
    private String[] osType;

    /**
     * 新增操作系统名称查询参数
     */
    private String[] osName;

    public String[] getOsName() {
        return osName;
    }

    public void setOsName(String[] osName) {
        this.osName = osName;
    }

    /**
     * 新增属性：可用域ID
     */
    private Long azId;

    private String azName;

    private String azCode;

    private Long projectId;

    private String projectName;

    private String orgCode;

    private String instanceName;

    private Long instanceId;

    private String[] status;

    private String tenantId;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     * 当前登录用户所属项目列表
     */
    private List<Long> staffProjects;

    /**
     * 私网ip地址
     */
    private String ipv4Address;

    /**
     * 用于查询条件，多选
     */
    private Long[] azIds;

    public String getIpv4Address() {
        return ipv4Address;
    }

    public void setIpv4Address(String ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    /**
     * 订单编号    ---新增
     */
    private String masterOrderId;

    private Integer sort;

    public String[] getOsType() {
        return osType;
    }

    public void setOsType(String[] osType) {
        this.osType = osType;
    }

    public String getMasterOrderId() {
        return masterOrderId;
    }

    public void setMasterOrderId(String masterOrderId) {
        this.masterOrderId = masterOrderId;
    }

    public List<Long> getStaffProjects() {
        return staffProjects;
    }

    public void setStaffProjects(List<Long> staffProjects) {
        this.staffProjects = staffProjects;
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

    public String[] getCloudCode() {
        return cloudCode;
    }

    public void setCloudCode(String[] cloudCode) {
        this.cloudCode = cloudCode;
    }

    public String[] getCloudType() {
        return cloudType;
    }

    public void setCloudType(String[] cloudType) {
        this.cloudType = cloudType;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String[] getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String[] regionCode) {
        this.regionCode = regionCode;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getAzId() {
        return azId;
    }

    public void setAzId(Long azId) {
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long[] getAzIds() {
        return azIds;
    }

    public void setAzIds(Long[] azIds) {
        this.azIds = azIds;
    }
}
