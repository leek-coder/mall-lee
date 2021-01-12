package com.huatech.mall.model;

import java.util.Date;

/**
 *  
 * @author like
 * @date 2021-01-11 
 */
public class Book {
    /**
     * 
     * 表字段:id
     */
    private Integer id;

    /**
     * 
     * 表字段:name
     */
    private String name;

    /**
     * 
     * 表字段:en_name
     */
    private String enName;

    /**
     * 
     * 表字段:author
     */
    private String author;

    /**
     * 
     * 表字段:img_url
     */
    private String imgUrl;

    /**
     * 
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段:creator
     */
    private Integer creator;

    /**
     * 
     * 表字段:update_time
     */
    private Date updateTime;

    /**
     * 1正常，-1删除，0下架
     * 表字段:status
     */
    private Integer status;

    /**
     * 评论数
     * 表字段:comment_num
     */
    private Integer commentNum;

    /**
     * 价格，分
     * 表字段:price
     */
    private Integer price;

    /**
     * 
     * 表字段:category
     */
    private String category;

    /**
     * 
     * 表字段:description
     */
    private String description;

    /**
     * 获取
     * @return id Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取
     * @return enName String
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置
     * @param enName 
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * 获取
     * @return author String
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author 
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取
     * @return imgUrl String
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置
     * @param imgUrl 
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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
     * @return creator Integer
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 设置
     * @param creator 
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
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

    /**
     * 获取1正常，-1删除，0下架
     * @return status Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1正常，-1删除，0下架
     * @param status 1正常，-1删除，0下架
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取评论数
     * @return commentNum Integer
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * 设置评论数
     * @param commentNum 评论数
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * 获取价格，分
     * @return price Integer
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置价格，分
     * @param price 价格，分
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取
     * @return category String
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置
     * @param category 
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
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
}