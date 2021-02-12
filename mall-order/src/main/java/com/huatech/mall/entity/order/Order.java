package com.huatech.mall.entity.order;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  
 * 表:t_order 
 * @author like 
 * @date 2020-06-22 
 */
@Component
public   class Order {
    /**
     * 订单唯一标识
     * 表字段:id
     */
    private Long id;

    /**
     * 用户地址标识id
     * 表字段:address_id
     */
    private Long addressId;

    /**
     * 优惠券id
     * 表字段:coupon_id
     */
    private Long couponId;

    /**
     * 订单编号
     * 表字段:order_no
     */
    private String orderNo;

    /**
     * 支付类型 1:支付宝 2:微信
     * 表字段:pay_type
     */
    private String payType;

    /**
     * 订单金额
     * 表字段:price
     */
    private Double price;

    /**
     * 订单状态  -1 删除 1:待付款，2:已付款 3：已取消  4:已完成  -1 删除 1:待付款，2：已付款 3：已发货：4：已收货  5:已退款完成  6：完结 7：取消  8已过期,9退款中
     * 表字段:status
     */
    private String status;

    /**
     * 用户id
     * 表字段:user_id
     */
    private Long userId;

    /**
     * 商品数量
     * 表字段:num
     */
    private Integer num;

    /**
     * 是否可以开发票  0：不苛 1：可以
     * 表字段:if_can_invoice
     */
    private String ifCanInvoice;

    /**
     * 发票抬头
     * 表字段:invoice_title
     */
    private String invoiceTitle;

    /**
     * 优惠券金额
     * 表字段:coupon_price
     */
    private Double couponPrice;

    /**
     * 创建人
     * 表字段:create_user
     */
    private Long createUser;

    /**
     * 描述
     * 表字段:summary
     */
    private String summary;

    /**
     * 支付人
     * 表字段:pay_user
     */
    private String payUser;

    /**
     * 支付单id
     * 表字段:pay_id
     */
    private String payId;

    /**
     * 支付时间
     * 表字段:pay_time
     */
    private Date payTime;

    /**
     * 订单来源 来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     * 表字段:source
     */
    private String source;

    /**
     * 物流公司名称
     * 表字段:logistics_company_name
     */
    private String logisticsCompanyName;

    /**
     * 运单号
     * 表字段:ogistics_bill_no
     */
    private String ogisticsBillNo;

    /**
     * 如果订单里有限时购，则该字段就为限时购id
     * 表字段:timing_activity_id
     */
    private String timingActivityId;

    /**
     * 订单备注
     * 表字段:remark
     */
    private String remark;

    /**
     * 订单创建时间
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 订单更新时间
     * 表字段:update_time
     */
    private Date updateTime;

    /**
     * 物流公司id
     * 表字段:logistics_company_id
     */
    private String logisticsCompanyId;

    /**
     * 获取订单唯一标识
     * @return id Long
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置订单唯一标识
     * @param id 订单唯一标识
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户地址标识id
     * @return addressId Long
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * 设置用户地址标识id
     * @param addressId 用户地址标识id
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
     * 获取订单编号
     * @return orderNo String
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 获取支付类型 1:支付宝 2:微信
     * @return payType String
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型 1:支付宝 2:微信
     * @param payType 支付类型 1:支付宝 2:微信
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 获取订单金额
     * @return price Double
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置订单金额
     * @param price 订单金额
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取订单状态  -1 删除 1:待付款，2:已付款 3：已取消  4:已完成  -1 删除 1:待付款，2：已付款 3：已发货：4：已收货  5:已退款完成  6：完结 7：取消  8已过期,9退款中
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置订单状态  -1 删除 1:待付款，2:已付款 3：已取消  4:已完成  -1 删除 1:待付款，2：已付款 3：已发货：4：已收货  5:已退款完成  6：完结 7：取消  8已过期,9退款中
     * @param status 订单状态  -1 删除 1:待付款，2:已付款 3：已取消  4:已完成  -1 删除 1:待付款，2：已付款 3：已发货：4：已收货  5:已退款完成  6：完结 7：取消  8已过期,9退款中
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 获取商品数量
     * @return num Integer
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置商品数量
     * @param num 商品数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取是否可以开发票  0：不苛 1：可以
     * @return ifCanInvoice String
     */
    public String getIfCanInvoice() {
        return ifCanInvoice;
    }

    /**
     * 设置是否可以开发票  0：不苛 1：可以
     * @param ifCanInvoice 是否可以开发票  0：不苛 1：可以
     */
    public void setIfCanInvoice(String ifCanInvoice) {
        this.ifCanInvoice = ifCanInvoice == null ? null : ifCanInvoice.trim();
    }

    /**
     * 获取发票抬头
     * @return invoiceTitle String
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 设置发票抬头
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
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
     * 获取创建人
     * @return createUser Long
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     * @param createUser 创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取描述
     * @return summary String
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置描述
     * @param summary 描述
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 获取支付人
     * @return payUser String
     */
    public String getPayUser() {
        return payUser;
    }

    /**
     * 设置支付人
     * @param payUser 支付人
     */
    public void setPayUser(String payUser) {
        this.payUser = payUser == null ? null : payUser.trim();
    }

    /**
     * 获取支付单id
     * @return payId String
     */
    public String getPayId() {
        return payId;
    }

    /**
     * 设置支付单id
     * @param payId 支付单id
     */
    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    /**
     * 获取支付时间
     * @return payTime Date
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取订单来源 来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     * @return source String
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置订单来源 来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     * @param source 订单来源 来源 1.商城2.大数据推荐3.关爱父母套餐4.IM医生推荐5.异常复查6.push消息7.体检预约慈记加项8.商城顶部banner
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取物流公司名称
     * @return logisticsCompanyName String
     */
    public String getLogisticsCompanyName() {
        return logisticsCompanyName;
    }

    /**
     * 设置物流公司名称
     * @param logisticsCompanyName 物流公司名称
     */
    public void setLogisticsCompanyName(String logisticsCompanyName) {
        this.logisticsCompanyName = logisticsCompanyName == null ? null : logisticsCompanyName.trim();
    }

    /**
     * 获取运单号
     * @return ogisticsBillNo String
     */
    public String getOgisticsBillNo() {
        return ogisticsBillNo;
    }

    /**
     * 设置运单号
     * @param ogisticsBillNo 运单号
     */
    public void setOgisticsBillNo(String ogisticsBillNo) {
        this.ogisticsBillNo = ogisticsBillNo == null ? null : ogisticsBillNo.trim();
    }

    /**
     * 获取如果订单里有限时购，则该字段就为限时购id
     * @return timingActivityId String
     */
    public String getTimingActivityId() {
        return timingActivityId;
    }

    /**
     * 设置如果订单里有限时购，则该字段就为限时购id
     * @param timingActivityId 如果订单里有限时购，则该字段就为限时购id
     */
    public void setTimingActivityId(String timingActivityId) {
        this.timingActivityId = timingActivityId == null ? null : timingActivityId.trim();
    }

    /**
     * 获取订单备注
     * @return remark String
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置订单备注
     * @param remark 订单备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取订单创建时间
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取订单更新时间
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置订单更新时间
     * @param updateTime 订单更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取物流公司id
     * @return logisticsCompanyId String
     */
    public String getLogisticsCompanyId() {
        return logisticsCompanyId;
    }

    /**
     * 设置物流公司id
     * @param logisticsCompanyId 物流公司id
     */
    public void setLogisticsCompanyId(String logisticsCompanyId) {
        this.logisticsCompanyId = logisticsCompanyId == null ? null : logisticsCompanyId.trim();
    }
}