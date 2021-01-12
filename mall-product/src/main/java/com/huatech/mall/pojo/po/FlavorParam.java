package com.huatech.mall.pojo.po;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 规格入参
 *
 * @author like
 * @date 2020-09-09 9:34 上午
 **/
public class FlavorParam implements Serializable {

    /**
     * 类型
     */
    private String type;

    /**
     * 规格唯一标示
     */
    @NotBlank(message = "请选择产品信息")
    private String flavorUuid;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlavorUuid() {
        return flavorUuid;
    }

    public void setFlavorUuid(String flavorUuid) {
        this.flavorUuid = flavorUuid;
    }

    @Override
    public String toString() {
        return "FlavorParam{" +
                "type='" + type + '\'' +
                ", flavorUuid='" + flavorUuid + '\'' +
                '}';
    }
}