package com.huatech.mall.pojo.po;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 镜像入参
 *
 * @author like
 * @date 2020-09-09 9:37 上午
 **/
public class ImageParam implements Serializable {

    /**
     * 镜像类型
     */
    private String type;

    /**
     * 镜像标示
     */
    @NotBlank(message = "请选择镜像")
    private String imageUuid;

    /**
     * 启动方式
     */
    private String bootMode;

    /**
     * 镜像产品id
     */
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUuid() {
        return imageUuid;
    }

    public void setImageUuid(String imageUuid) {
        this.imageUuid = imageUuid;
    }

    public String getBootMode() {
        return bootMode;
    }

    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    @Override
    public String toString() {
        return "ImageParam{" +
                "type='" + type + '\'' +
                ", imageUuid='" + imageUuid + '\'' +
                ", bootMode='" + bootMode + '\'' +
                '}';
    }
}