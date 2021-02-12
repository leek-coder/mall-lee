package com.huatech.mall.entity;

import java.util.Date;

/**
 * 表:t_dis_trans_message
 *
 * @author like
 * @date 2020-06-25
 */
public class DisTransMessage {
    /**
     * 主键
     * 表字段:id
     */
    private Long id;

    /**
     * 业务id
     * 表字段:biz_id
     */
    private String bizId;

    /**
     * 业务数据
     * 表字段:biz_data
     */
    private String bizData;

    /**
     * 业务类型
     * 表字段:biz_type
     */
    private String bizType;

    /**
     * 状态1:初始，2:发送，3:结束
     * 表字段:status
     */
    private Integer status;

    /**
     * 创建时间
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * 表字段:update_time
     */
    private Date updateTime;

    public DisTransMessage(String bizId, String bizData, String bizType, Integer status) {
        this.bizId = bizId;
        this.bizData = bizData;
        this.bizType = bizType;
        this.status = status;
    }
    public DisTransMessage(){}


    /**
     * 获取主键
     *
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取业务id
     *
     * @return bizId String
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 设置业务id
     *
     * @param bizId 业务id
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * 获取业务数据
     *
     * @return bizData String
     */
    public String getBizData() {
        return bizData;
    }

    /**
     * 设置业务数据
     *
     * @param bizData 业务数据
     */
    public void setBizData(String bizData) {
        this.bizData = bizData == null ? null : bizData.trim();
    }

    /**
     * 获取业务类型
     *
     * @return bizType String
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 设置业务类型
     *
     * @param bizType 业务类型
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    /**
     * 获取状态1:初始，2:发送，3:结束
     *
     * @return status Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态1:初始，2:发送，3:结束
     *
     * @param status 状态1:初始，2:发送，3:结束
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}