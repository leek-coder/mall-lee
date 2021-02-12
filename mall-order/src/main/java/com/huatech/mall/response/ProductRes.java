package com.huatech.mall.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author like
 * @date 2020-6-22
 */
public class ProductRes implements Serializable {
    /**
     * 商品主键
     */
    private String productId;

    /**
     * 所属类目
     */
    private String categoryNo;

    /**
     * 商品大图
     */
    private String productImage;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 上架状态 1已上架 2 已下架 3未上架
     */
    private Integer productStatus;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品上架时间
     */
    private Date productStartTime;

    /**
     * 商品下架时间
     */
    private Date productEndTime;

    /**
     * 销售平台：1所有平台，2微信,3客户端
     */
    private Integer productSalesType;

    /**
     * 是否推荐 2：否 1：是
     */
    private Integer productIfRecommend;

    /**
     * 现价
     */
    private Double productNowPrice;

    /**
     * 现价描述
     */
    private String productNowPriceDescription;

    /**
     * 原价
     */
    private Double productOriginalPrice;

    /**
     * 已经售出数量
     */
    private Integer productSoldNum;

    /**
     * 商品简介
     */
    private String productSummary;

    /**
     * 此种商品是否可以开具发票  2：否 1是
     */
    private Integer productIfCanInvoice;

    /**
     * 商品类型 2:虚拟商品 1:实物商品
     */
    private Integer productGoodsType;

    private String productUpdateUser;

    private String productCreateUser;

    /**
     * 推荐商品开始时间
     */
    private Date productCommendStartTime;

    /**
     * 推荐商品结束时间
     */
    private Date productCommendEndTime;

    /**
     * 商品更新时间
     */
    private Date updateTime;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Date getProductStartTime() {
        return productStartTime;
    }

    public void setProductStartTime(Date productStartTime) {
        this.productStartTime = productStartTime;
    }

    public Date getProductEndTime() {
        return productEndTime;
    }

    public void setProductEndTime(Date productEndTime) {
        this.productEndTime = productEndTime;
    }

    public Integer getProductSalesType() {
        return productSalesType;
    }

    public void setProductSalesType(Integer productSalesType) {
        this.productSalesType = productSalesType;
    }

    public Integer getProductIfRecommend() {
        return productIfRecommend;
    }

    public void setProductIfRecommend(Integer productIfRecommend) {
        this.productIfRecommend = productIfRecommend;
    }

    public Double getProductNowPrice() {
        return productNowPrice;
    }

    public void setProductNowPrice(Double productNowPrice) {
        this.productNowPrice = productNowPrice;
    }

    public String getProductNowPriceDescription() {
        return productNowPriceDescription;
    }

    public void setProductNowPriceDescription(String productNowPriceDescription) {
        this.productNowPriceDescription = productNowPriceDescription;
    }

    public Double getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(Double productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public Integer getProductSoldNum() {
        return productSoldNum;
    }

    public void setProductSoldNum(Integer productSoldNum) {
        this.productSoldNum = productSoldNum;
    }

    public String getProductSummary() {
        return productSummary;
    }

    public void setProductSummary(String productSummary) {
        this.productSummary = productSummary;
    }

    public Integer getProductIfCanInvoice() {
        return productIfCanInvoice;
    }

    public void setProductIfCanInvoice(Integer productIfCanInvoice) {
        this.productIfCanInvoice = productIfCanInvoice;
    }

    public Integer getProductGoodsType() {
        return productGoodsType;
    }

    public void setProductGoodsType(Integer productGoodsType) {
        this.productGoodsType = productGoodsType;
    }

    public String getProductUpdateUser() {
        return productUpdateUser;
    }

    public void setProductUpdateUser(String productUpdateUser) {
        this.productUpdateUser = productUpdateUser;
    }

    public String getProductCreateUser() {
        return productCreateUser;
    }

    public void setProductCreateUser(String productCreateUser) {
        this.productCreateUser = productCreateUser;
    }

    public Date getProductCommendStartTime() {
        return productCommendStartTime;
    }

    public void setProductCommendStartTime(Date productCommendStartTime) {
        this.productCommendStartTime = productCommendStartTime;
    }

    public Date getProductCommendEndTime() {
        return productCommendEndTime;
    }

    public void setProductCommendEndTime(Date productCommendEndTime) {
        this.productCommendEndTime = productCommendEndTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductRes{" +
                "productId='" + productId + '\'' +
                ", categoryNo='" + categoryNo + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productName='" + productName + '\'' +
                ", productStatus=" + productStatus +
                ", productStock=" + productStock +
                ", createTime=" + createTime +
                ", productDescription='" + productDescription + '\'' +
                ", productStartTime=" + productStartTime +
                ", productEndTime=" + productEndTime +
                ", productSalesType=" + productSalesType +
                ", productIfRecommend=" + productIfRecommend +
                ", productNowPrice=" + productNowPrice +
                ", productNowPriceDescription='" + productNowPriceDescription + '\'' +
                ", productOriginalPrice=" + productOriginalPrice +
                ", productSoldNum=" + productSoldNum +
                ", productSummary='" + productSummary + '\'' +
                ", productIfCanInvoice=" + productIfCanInvoice +
                ", productGoodsType=" + productGoodsType +
                ", productUpdateUser='" + productUpdateUser + '\'' +
                ", productCreateUser='" + productCreateUser + '\'' +
                ", productCommendStartTime=" + productCommendStartTime +
                ", productCommendEndTime=" + productCommendEndTime +
                ", updateTime=" + updateTime +
                '}';
    }
}