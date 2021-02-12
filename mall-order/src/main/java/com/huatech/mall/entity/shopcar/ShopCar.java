package com.huatech.mall.entity.shopcar;

import java.util.Date;

/**
 *  
 * 表:t_shop_car 
 * @author like 
 * @date 2020-06-22 
 */
public class ShopCar {
    /**
     * 购物车id
     * 表字段:id
     */
    private Long id;

    /**
     * 用户id
     * 表字段:user_id
     */
    private Long userId;

    /**
     * 商品id
     * 表字段:product_id
     */
    private String productId;

    /**
     * 商品数量
     * 表字段:product_num
     */
    private Integer productNum;

    /**
     * 商品名称
     * 表字段:product_name
     */
    private String productName;

    /**
     * 商品金额
     * 表字段:product_price
     */
    private Double productPrice;

    /**
     * status：状态-1删除0正常
     * 表字段:status
     */
    private String status;

    /**
     * 来源来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     * 表字段:source
     */
    private String source;

    /**
     * 购物车创建时间
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 购物车更新时间
     * 表字段:update_time
     */
    private Date updateTime;

    /**
     * 获取购物车id
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置购物车id
     * @param id 购物车id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     * @return userId Long
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取商品id
     * @return productId String
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置商品id
     * @param productId 商品id
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 获取商品数量
     * @return productNum Integer
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * 设置商品数量
     * @param productNum 商品数量
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    /**
     * 获取商品名称
     * @return productName String
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取商品金额
     * @return productPrice Double
     */
    public Double getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品金额
     * @param productPrice 商品金额
     */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取status：状态-1删除0正常
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status：状态-1删除0正常
     * @param status status：状态-1删除0正常
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取来源来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     * @return source String
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     * @param source 来源来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取购物车创建时间
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置购物车创建时间
     * @param createTime 购物车创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取购物车更新时间
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置购物车更新时间
     * @param updateTime 购物车更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}