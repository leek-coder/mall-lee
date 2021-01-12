package com.huatech.mall.enums;

/**
 * 系统错误码
 *
 * @author like
 * @date 2019-11-30 9:09 上午
 **/
public enum ApiBaseErrorCore {
    MISS_PARAM_ERROR("参数缺失", 5000),

    USER_NOT_EXISTS("用户不存在", 1000),
    USER_EXISTS("用户已存在", 1001),
    PASSWORD_ERROR("密码错误", 1002),
    PHONE_EXISTS("手机号已存在", 1003),
    DELETE_NOT_ALLOWED("当前用户不可以删除自己", 1004),
    EXPERIENCE_NOT_ALLOWED("体验用户不可被删除", 1005),
    ROLE_NOT_ALLOWED("该用户不允许被修改角色", 1006),


    ROLE_NOT_EXISTS("角色不存在", 2000),
    ROLE_EXISTS("角色已存在", 2001),
    ROLE_KEY_EXISTS("角色key已存在", 2002),
    ADMIN_ROLE_NOT("超级管理员不能被删除", 2003),
    /**
     * ===================================商品==========================
     */
    RESOURCE_NOT_EXISTS("资源不存在", 3000),
    PRODUCT_NOT_EXISTS("商品不存在", 3001),
    PRODUCT_OUT_OF_STOCK("商品库存不足", 3002),
    PRODUCT_ID_NOT_NULL("请选择秒杀商品", 3003),

    TOKEN_FAIL("Token验证失败", 4000),
    TOKEN_IS_EXPIRED("Token已过期", 4001),
    TOKEN_IS_VALID("Token不合法", 4002),

    REMOTE_SERVICE_FAIL("远程服务调用失败", 5000),
    JSON_TRANS_ERROR("参数转化异常", 5001),
    AUTH_REMOTE_FAIL("远程调用鉴权服务失败", 5002),


    CATEGORY_NOT_EXISTS("类目不存在", 6001),
    CATEGORY_EXISTS("类目不存在", 6002),
    REQUIRE_UPLOAD_IMAGE("三级分类需要上传图片", 6003),


    PRODUCT_BRAND_NOT_EXISTS("商品品牌不存在", 7001),
    PRODUCT_BRAND_EXISTS("商品品牌已存在", 7002),
    PRODUCT_ATTRIBUTE_CATEGORY_NOT_EXISTS("商品类型不存在", 7003),
    PRODUCT_ATTRIBUTE_CATEGORY_EXISTS("商品类型已存在", 7004),
    PRODUCT_ATTRIBUTE_NOT_EXISTS("该商品类型属性不存在", 7005),
    PRODUCT_ATTRIBUTE_EXISTS("该商品类型属性已存在", 7006),
    ;


    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ApiBaseErrorCore(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}