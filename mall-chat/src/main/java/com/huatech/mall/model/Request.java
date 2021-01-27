package com.huatech.mall.model;

import java.util.Date;

/**
 *  
 * 表:request 
 * @author like 
 * @date 2021-01-27 
 */
public class Request {
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
     * 发送请求的事件
     * 表字段:request_date_time
     */
    private Date requestDateTime;

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
     * 获取发送请求的事件
     * @return requestDateTime Date
     */
    public Date getRequestDateTime() {
        return requestDateTime;
    }

    /**
     * 设置发送请求的事件
     * @param requestDateTime 发送请求的事件
     */
    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }
}