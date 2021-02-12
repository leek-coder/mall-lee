package com.huatech.mall.entity.order;

import java.util.Date;

/**
 *  
 * 表:t_sub_order 
 * @author like 
 * @date 2020-06-22 
 */
public class SubOrder {
    /**
     * 子订单唯一标志
     * 表字段:id
     */
    private Long id;

    /**
     * 关联订单id
     * 表字段:order_no
     */
    private String orderNo;

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
     * 子订单状态 1:待付款
     * 表字段:status
     */
    private String status;

    /**
     * 价格
     * 表字段:price
     */
    private Double price;

    /**
     * 退货id
     * 表字段:refund_id
     */
    private Long refundId;

    /**
     * 用户id
     * 表字段:user_id
     */
    private Long userId;

    /**
     * 优惠券id
     * 表字段:coupon_id
     */
    private Long couponId;

    /**
     * 优惠券金额
     * 表字段:coupon_price
     */
    private Double couponPrice;

    /**
     * 来源
     * 表字段:source
     */
    private String source;

    /**
     * 商品图片
     * 表字段:product_image
     */
    private String productImage;

    /**
     * 子订单创建时间
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 子订单更新时间
     * 表字段:update_time
     */
    private Date updateTime;

    /**
     * 获取子订单唯一标志
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置子订单唯一标志
     * @param id 子订单唯一标志
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取关联订单id
     * @return orderNo String
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置关联订单id
     * @param orderNo 关联订单id
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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
     * 获取子订单状态 1:待付款
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置子订单状态 1:待付款
     * @param status 子订单状态 1:待付款
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取价格
     * @return price Double
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     * @param price 价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取退货id
     * @return refundId Long
     */
    public Long getRefundId() {
        return refundId;
    }

    /**
     * 设置退货id
     * @param refundId 退货id
     */
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
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
     * 获取优惠券id
     * @return couponId Long
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * 设置优惠券id
     * @param couponId 优惠券id
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取优惠券金额
     * @return couponPrice Double
     */
    public Double getCouponPrice() {
        return couponPrice;
    }

    /**
     * 设置优惠券金额
     * @param couponPrice 优惠券金额
     */
    public void setCouponPrice(Double couponPrice) {
        this.couponPrice = couponPrice;
    }

    /**
     * 获取来源
     * @return source String
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取商品图片
     * @return productImage String
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * 设置商品图片
     * @param productImage 商品图片
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    /**
     * 获取子订单创建时间
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置子订单创建时间
     * @param createTime 子订单创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取子订单更新时间
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置子订单更新时间
     * @param updateTime 子订单更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}