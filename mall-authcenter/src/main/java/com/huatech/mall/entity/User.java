package com.huatech.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 *  
 * 表:t_user 
 * @author like 
 * @date 2019-12-03 
 */
public class User {
    /**
     * 
     * 表字段:id
     */
    private Long id;

    /**
     * 
     * 表字段:user_name
     */
    private String userName;

    /**
     * 
     * 表字段:nick_name
     */
    private String nickName;

    /**
     * 
     * 表字段:sex
     */
    private Integer sex;


    /**
     * 
     * 表字段:telephone
     */
    private String telephone;


    /**
     * 
     * 表字段:password
     */
    @JsonIgnore
    private String password;

    /**
     * 
     * 表字段:delete_status
     */
    private Integer deleteStatus;

    /**
     * 
     * 表字段:email
     */
    private String email;

    /**
     * 
     * 表字段:locked
     */
    private Integer locked;

    /**
     * 
     * 表字段:description
     */
    private String description;

    /**
     * 
     * 表字段:create_time
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 
     * 表字段:update_time
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 获取
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return userName String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取
     * @return nickName String
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置
     * @param nickName 
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取
     * @return sex Integer
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex 
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }





    /**
     * 获取
     * @return telephone String
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置
     * @param telephone 
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }


    /**
     * 获取
     * @return password String
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取
     * @return deleteStatus Integer
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置
     * @param deleteStatus 
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取
     * @return locked Integer
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 设置
     * @param locked 
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 获取
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", deleteStatus=" + deleteStatus +
                ", email='" + email + '\'' +
                ", locked=" + locked +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}