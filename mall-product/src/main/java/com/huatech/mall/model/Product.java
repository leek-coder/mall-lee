package com.huatech.mall.model;

import java.io.Serializable;
import java.util.Date;

/**
 *  
 * 表:t_product 
 * @author like 
 * @date 2019-12-19 
 */
public class Product implements Serializable {
    /**
     * 商品主键
     * 表字段:product_id
     */
    private String productId;

    /**
     * 所属类目
     * 表字段:category_no
     */
    private String categoryNo;

    /**
     * 商品大图
     * 表字段:product_image
     */
    private String productImage;

    /**
     * 商品名称
     * 表字段:product_name
     */
    private String productName;

    /**
     * 上架状态 1已上架 2 已下架 3未上架
     * 表字段:product_status
     */
    private Integer productStatus;

    /**
     * 商品库存
     * 表字段:product_stock
     */
    private Integer productStock;

    /**
     * 创建时间
     * 表字段:create_time
     */
    private Date createTime;

    /**
     * 商品描述
     * 表字段:product_description
     */
    private String productDescription;

    /**
     * 商品上架时间
     * 表字段:product_start_time
     */
    private Date productStartTime;

    /**
     * 商品下架时间
     * 表字段:product_end_time
     */
    private Date productEndTime;

    /**
     * 销售平台：1所有平台，2微信,3客户端
     * 表字段:product_sales_type
     */
    private Integer productSalesType;

    /**
     * 是否推荐 2：否 1：是
     * 表字段:product_if_recommend
     */
    private Integer productIfRecommend;

    /**
     * 现价
     * 表字段:product_now_price
     */
    private Double productNowPrice;

    /**
     * 现价描述
     * 表字段:product_now_price_description
     */
    private String productNowPriceDescription;

    /**
     * 原价
     * 表字段:product_original_price
     */
    private Double productOriginalPrice;

    /**
     * 已经售出数量
     * 表字段:product_sold_num
     */
    private Integer productSoldNum;

    /**
     * 商品简介
     * 表字段:product_summary
     */
    private String productSummary;

    /**
     * 此种商品是否可以开具发票  2：否 1是
     * 表字段:product_if_can_invoice
     */
    private Integer productIfCanInvoice;

    /**
     * 商品类型 2:虚拟商品 1:实物商品
     * 表字段:product_goods_type
     */
    private Integer productGoodsType;

    /**
     * 
     * 表字段:product_update_user
     */
    private String productUpdateUser;

    /**
     * 
     * 表字段:product_create_user
     */
    private String productCreateUser;

    /**
     * 推荐商品开始时间
     * 表字段:product_commend_start_time
     */
    private Date productCommendStartTime;

    /**
     * 推荐商品结束时间
     * 表字段:product_commend_end_time
     */
    private Date productCommendEndTime;

    /**
     * 商品更新时间
     * 表字段:update_time
     */
    private Date updateTime;

    /**
     * 获取商品主键
     * @return productId String
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置商品主键
     * @param productId 商品主键
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 获取所属类目
     * @return categoryNo String
     */
    public String getCategoryNo() {
        return categoryNo;
    }

    /**
     * 设置所属类目
     * @param categoryNo 所属类目
     */
    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo == null ? null : categoryNo.trim();
    }

    /**
     * 获取商品大图
     * @return productImage String
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * 设置商品大图
     * @param productImage 商品大图
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
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
     * 获取上架状态 1已上架 2 已下架 3未上架
     * @return productStatus Integer
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * 设置上架状态 1已上架 2 已下架 3未上架
     * @param productStatus 上架状态 1已上架 2 已下架 3未上架
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 获取商品库存
     * @return productStock Integer
     */
    public Integer getProductStock() {
        return productStock;
    }

    /**
     * 设置商品库存
     * @param productStock 商品库存
     */
    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    /**
     * 获取创建时间
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取商品描述
     * @return productDescription String
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * 设置商品描述
     * @param productDescription 商品描述
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
    }

    /**
     * 获取商品上架时间
     * @return productStartTime Date
     */
    public Date getProductStartTime() {
        return productStartTime;
    }

    /**
     * 设置商品上架时间
     * @param productStartTime 商品上架时间
     */
    public void setProductStartTime(Date productStartTime) {
        this.productStartTime = productStartTime;
    }

    /**
     * 获取商品下架时间
     * @return productEndTime Date
     */
    public Date getProductEndTime() {
        return productEndTime;
    }

    /**
     * 设置商品下架时间
     * @param productEndTime 商品下架时间
     */
    public void setProductEndTime(Date productEndTime) {
        this.productEndTime = productEndTime;
    }

    /**
     * 获取销售平台：1所有平台，2微信,3客户端
     * @return productSalesType Integer
     */
    public Integer getProductSalesType() {
        return productSalesType;
    }

    /**
     * 设置销售平台：1所有平台，2微信,3客户端
     * @param productSalesType 销售平台：1所有平台，2微信,3客户端
     */
    public void setProductSalesType(Integer productSalesType) {
        this.productSalesType = productSalesType;
    }

    /**
     * 获取是否推荐 2：否 1：是
     * @return productIfRecommend Integer
     */
    public Integer getProductIfRecommend() {
        return productIfRecommend;
    }

    /**
     * 设置是否推荐 2：否 1：是
     * @param productIfRecommend 是否推荐 2：否 1：是
     */
    public void setProductIfRecommend(Integer productIfRecommend) {
        this.productIfRecommend = productIfRecommend;
    }

    /**
     * 获取现价
     * @return productNowPrice Double
     */
    public Double getProductNowPrice() {
        return productNowPrice;
    }

    /**
     * 设置现价
     * @param productNowPrice 现价
     */
    public void setProductNowPrice(Double productNowPrice) {
        this.productNowPrice = productNowPrice;
    }

    /**
     * 获取现价描述
     * @return productNowPriceDescription String
     */
    public String getProductNowPriceDescription() {
        return productNowPriceDescription;
    }

    /**
     * 设置现价描述
     * @param productNowPriceDescription 现价描述
     */
    public void setProductNowPriceDescription(String productNowPriceDescription) {
        this.productNowPriceDescription = productNowPriceDescription == null ? null : productNowPriceDescription.trim();
    }

    /**
     * 获取原价
     * @return productOriginalPrice Double
     */
    public Double getProductOriginalPrice() {
        return productOriginalPrice;
    }

    /**
     * 设置原价
     * @param productOriginalPrice 原价
     */
    public void setProductOriginalPrice(Double productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    /**
     * 获取已经售出数量
     * @return productSoldNum Integer
     */
    public Integer getProductSoldNum() {
        return productSoldNum;
    }

    /**
     * 设置已经售出数量
     * @param productSoldNum 已经售出数量
     */
    public void setProductSoldNum(Integer productSoldNum) {
        this.productSoldNum = productSoldNum;
    }

    /**
     * 获取商品简介
     * @return productSummary String
     */
    public String getProductSummary() {
        return productSummary;
    }

    /**
     * 设置商品简介
     * @param productSummary 商品简介
     */
    public void setProductSummary(String productSummary) {
        this.productSummary = productSummary == null ? null : productSummary.trim();
    }

    /**
     * 获取此种商品是否可以开具发票  2：否 1是
     * @return productIfCanInvoice Integer
     */
    public Integer getProductIfCanInvoice() {
        return productIfCanInvoice;
    }

    /**
     * 设置此种商品是否可以开具发票  2：否 1是
     * @param productIfCanInvoice 此种商品是否可以开具发票  2：否 1是
     */
    public void setProductIfCanInvoice(Integer productIfCanInvoice) {
        this.productIfCanInvoice = productIfCanInvoice;
    }

    /**
     * 获取商品类型 2:虚拟商品 1:实物商品
     * @return productGoodsType Integer
     */
    public Integer getProductGoodsType() {
        return productGoodsType;
    }

    /**
     * 设置商品类型 2:虚拟商品 1:实物商品
     * @param productGoodsType 商品类型 2:虚拟商品 1:实物商品
     */
    public void setProductGoodsType(Integer productGoodsType) {
        this.productGoodsType = productGoodsType;
    }

    /**
     * 获取
     * @return productUpdateUser String
     */
    public String getProductUpdateUser() {
        return productUpdateUser;
    }

    /**
     * 设置
     * @param productUpdateUser 
     */
    public void setProductUpdateUser(String productUpdateUser) {
        this.productUpdateUser = productUpdateUser == null ? null : productUpdateUser.trim();
    }

    /**
     * 获取
     * @return productCreateUser String
     */
    public String getProductCreateUser() {
        return productCreateUser;
    }

    /**
     * 设置
     * @param productCreateUser 
     */
    public void setProductCreateUser(String productCreateUser) {
        this.productCreateUser = productCreateUser == null ? null : productCreateUser.trim();
    }

    /**
     * 获取推荐商品开始时间
     * @return productCommendStartTime Date
     */
    public Date getProductCommendStartTime() {
        return productCommendStartTime;
    }

    /**
     * 设置推荐商品开始时间
     * @param productCommendStartTime 推荐商品开始时间
     */
    public void setProductCommendStartTime(Date productCommendStartTime) {
        this.productCommendStartTime = productCommendStartTime;
    }

    /**
     * 获取推荐商品结束时间
     * @return productCommendEndTime Date
     */
    public Date getProductCommendEndTime() {
        return productCommendEndTime;
    }

    /**
     * 设置推荐商品结束时间
     * @param productCommendEndTime 推荐商品结束时间
     */
    public void setProductCommendEndTime(Date productCommendEndTime) {
        this.productCommendEndTime = productCommendEndTime;
    }

    /**
     * 获取商品更新时间
     * @return updateTime Date
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置商品更新时间
     * @param updateTime 商品更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}