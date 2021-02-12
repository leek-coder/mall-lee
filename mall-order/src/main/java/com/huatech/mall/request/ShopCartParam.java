package com.huatech.mall.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author leek
 * @Date 2020-06-12 上午9:55
 * @Version 1.0
 * @Description
 */
@Data
public class ShopCartParam implements Serializable {

    @NotNull(message = "请选择商品")
    private String productId;
    private String action;
    @NotNull(message = "选择商品数量")
    @Min(value = 1, message = "商品数量最小为1")
    private Integer productNum;
    private Long userId;
}
