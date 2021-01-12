package com.huatech.mall.pojo.vo;


import com.huatech.mall.pojo.po.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 云服务器创建请求参数
 *
 * @author leek
 * @date 2020-08-19 14:13 下午
 **/
public class ServerVO extends CommonVO {

    /**
     * 云服务商标示
     */
    @NotNull(message = "请选择云服务商")
    private Long cloudId;

    /**
     * 资源池
     */
    @NotNull(message = "请选择资源池")
    private Long regionId;

    /**
     * 可用域id
     */
    @NotNull(message = "请选择可用域")
    private Long azId;

    /**
     * 项目id
     */
    @NotNull(message = "请选择项目")
    private Long projectId;

    /**
     * 规格对象
     */
    @Valid
    private FlavorParam flavor;


    /**
     * 存储池id
     */
    private String dataStore;

    /**
     * 存储池名称
     */
    private String dataStoreName;
    /**
     * 镜像对象
     */
    @NotNull(message = "请选择镜像")
    @Valid
    private ImageParam image;

    /**
     * 磁盘对象
     */
    private VolumeParam volume;

    /**
     * 网络
     */
    private NetworkParam network;
    /**
     * 安全组规则
     */
    private SecurityParam security;

    private FloatIpParam floatIp;

    /**
     * 登陆密码
     */
    @NotBlank(message = "请输入主机密码")
    private String password;
    /**
     * 确认登陆密码
     */
    private String subPassword;

    /**
     * 主机hostId
     */
    private String hostId;

    /**
     * dns
     */
    private String dns;

    /**
     * dnsDomain
     */
    private String dnsDomain;
    /**
     * 申请主机数量
     */
    @NotNull(message = "请选择申请主机数量")
    @Min(value = 1, message = "最少一次申请一台云主机")
    @Max(value = 10, message = "最多申请十台云主机")
    private Integer count;

    /**
     * 网卡
     */
    private List<NetworkCardParam> networkCards;

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubPassword() {
        return subPassword;
    }

    public void setSubPassword(String subPassword) {
        this.subPassword = subPassword;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public NetworkParam getNetwork() {
        return network;
    }


    public void setNetwork(NetworkParam network) {
        this.network = network;
    }

    public SecurityParam getSecurity() {
        return security;
    }

    public void setSecurity(SecurityParam security) {
        this.security = security;
    }

    public FloatIpParam getFloatIp() {
        return floatIp;
    }

    public void setFloatIp(FloatIpParam floatIp) {
        this.floatIp = floatIp;
    }

    @Override
    public Long getCloudId() {
        return cloudId;
    }

    @Override
    public void setCloudId(Long cloudId) {
        this.cloudId = cloudId;
    }

    @Override
    public Long getRegionId() {
        return regionId;
    }

    @Override
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Override
    public Long getAzId() {
        return azId;
    }

    @Override
    public void setAzId(Long azId) {
        this.azId = azId;
    }

    @Override
    public Long getProjectId() {
        return projectId;
    }

    @Override
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public FlavorParam getFlavor() {
        return flavor;
    }

    public void setFlavor(FlavorParam flavor) {
        this.flavor = flavor;
    }

    public ImageParam getImage() {
        return image;
    }

    public void setImage(ImageParam image) {
        this.image = image;
    }

    public VolumeParam getVolume() {
        return volume;
    }

    public void setVolume(VolumeParam volume) {
        this.volume = volume;
    }

    public List<NetworkCardParam> getNetworkCards() {
        return networkCards;
    }

    public String getDataStore() {
        return dataStore;
    }

    public void setDataStore(String dataStore) {
        this.dataStore = dataStore;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getDnsDomain() {
        return dnsDomain;
    }

    public void setDnsDomain(String dnsDomain) {
        this.dnsDomain = dnsDomain;
    }

    public void setNetworkCards(List<NetworkCardParam> networkCards) {
        this.networkCards = networkCards;
    }

    public String getDataStoreName() {
        return dataStoreName;
    }

    public void setDataStoreName(String dataStoreName) {
        this.dataStoreName = dataStoreName;
    }

    @Override
    public String toString() {
        return "ServerVO{" +
                "cloudId=" + cloudId +
                ", regionId=" + regionId +
                ", azId=" + azId +
                ", projectId=" + projectId +
                ", flavor=" + flavor +
                ", image=" + image +
                ", volume=" + volume +
                ", network=" + network +
                ", security=" + security +
                ", floatIp=" + floatIp +
                ", password='" + password + '\'' +
                ", subPassword='" + subPassword + '\'' +
                ", count=" + count +
                ", networkCards=" + networkCards +
                '}';
    }
}
