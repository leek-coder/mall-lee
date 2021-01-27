package com.huatech.mall.model;

import java.util.Date;

/**
 *  
 * 表:message 
 * @author like 
 * @date 2021-01-27 
 */
public class Message {
    /**
     * 
     * 表字段:id
     */
    private String id;

    /**
     * 
     * 表字段:send_user_id
     */
    private String sendUserId;

    /**
     * 
     * 表字段:accept_user_id
     */
    private String acceptUserId;

    /**
     * 
     * 表字段:msg
     */
    private String msg;

    /**
     * 消息是否签收状态
 1：签收
 0：未签收
 
     * 表字段:sign_flag
     */
    private Integer signFlag;

    /**
     * 发送请求的事件
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 获取
     * @return id String
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取
     * @return sendUserId String
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /**
     * 设置
     * @param sendUserId 
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
    }

    /**
     * 获取
     * @return acceptUserId String
     */
    public String getAcceptUserId() {
        return acceptUserId;
    }

    /**
     * 设置
     * @param acceptUserId 
     */
    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId == null ? null : acceptUserId.trim();
    }

    /**
     * 获取
     * @return msg String
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg 
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * 获取消息是否签收状态
 1：签收
 0：未签收
 
     * @return signFlag Integer
     */
    public Integer getSignFlag() {
        return signFlag;
    }

    /**
     * 设置消息是否签收状态
 1：签收
 0：未签收
 
     * @param signFlag 消息是否签收状态
 1：签收
 0：未签收
 
     */
    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    /**
     * 获取发送请求的事件
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发送请求的事件
     * @param createTime 发送请求的事件
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}