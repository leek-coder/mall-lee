package com.huatech.mall.constants;

/**
 * 系统常量
 *
 * @author like
 * @date 2019-11-30 9:07 上午
 **/
public class ApiBaseConstants {


    public static Integer SERVICE_TYPE = 1001;

    /**
     * 构建索引成功
     */
    public static Integer BUILD_INDEX_SUCCESS = 200;

    /**
     * 调用远程服务成功表示码
     */
    public static final Integer REMOTE_SUCCESS = 200;

    /**
     * rabbitmq的队列，交换机，路由声明
     */
    public static final class RabbitMqConfig {

        /**
         * 快速下单队列
         */
        public static final String QUICK_ORDER_QUEUE = "quick_order_queue";
        /**
         * 快速下单交换机
         */
        public static final String QUICK_ORDER_EXCHANGE = "quick_order_exchange";
        /**
         * 快速下单路由key
         */
        public static final String QUICK_ORDER_ROUTER_KEY = "quick_order_key";


        /**
         * 处理分布式事务队列
         */
        public static final String DISTRIBUTE_TRANSACTION_QUEUE = "distribute_transaction_queue";
        /**
         * 处理分布式事务交换机
         */
        public static final String DISTRIBUTE_TRANSACTION_EXCHANGE = "distribute_transaction_exchange";
        /**
         * 处理分布式事务路由key
         */
        public static final String DISTRIBUTE_TRANSACTION_ROUTER_KEY = "distribute_transaction_key";


    }

    /**
     * 消息初始化
     */
    public static int MESSAGE_INIT = 1;
    /**
     * 消息发送
     */
    public static Integer MESSAGE_SEND = 2;
    /**
     * 消息完成
     */
    public static  Integer MESSAGE_END= 3;


    /**
     * redis  key值前缀
     */
    public static final class RedisKeyPrefix {
        /**
         * 商品库存
         */
        public static final String PRODUCT_STOCK = "product:detail:cache:";

        /**
         * 产品库存缓存
         */
        public static final String MIAOSHA_STOCK_CACHE_PREFIX = "miaosha:stock:cache:";

        /**
         * 已购买过商品的用户不能再次购买
         */
        public static final String MEMBER_BUYED_MIAOSHA_PREFIX = "buyed:miaosha:";

        /**
         * 秒杀用验证码限流
         */
        public static final String MIAOSHA_VERIFY_CODE_PREFIX =  "miaosha:verifycode:";

        /**
         * 秒杀token
         */
        public static final String MIAOSHA_TOKEN_PREFIX = "miaosha:token:";

        /**
         * 秒杀异步下单排队中
         * 0->排队中,-1->秒杀失败,>0 ->秒杀成功,对应的是订单编号
         */
        public static final String MIAOSHA_ASYNC_WAITING_PREFIX = "miaosha:async:waiting:";

        /**
         * 当前正在进行的秒杀商品缓存hash - key
         */
        public static final String FLASH_PROMOTION_PRODUCT_KEY = "flash:promotion:hashtable";

        /**
         * 存储在redis的hashtable当中秒杀活动信息
         */
        public static final String ACTIVE_FLASH_PROMOTION_KEY = "flash:promotion:info";

        /**
         * 当库存减到0时,需要做一次库存同步,存在预减
         */
        public static final String STOCK_REFRESHED_MESSAGE_PREFIX = "stock:refreshed:message:";

        /**
         * redis布隆过滤器key
         */
        public static final String PRODUCT_REDIS_BLOOM_FILTER = "product:redis:bloom:filter";
    }


    /**
     * 用户默认地址
     */
    public static final String USER_DEFAULT_ADDRESS = "user_default_address_";



    /**
     * 调用远程服务失败表示码
     */
    public static final Integer REMOTE_FAIL = 9999;
    /**
     * 男
     */
    public static final Integer MAN = 0;

    /**
     * 女
     */
    public static final Integer WOMAN = 1;

    /**
     * 已删除
     */
    public static final Integer HAD_DELETE_STATUS = 1;

    /**
     * 未删除
     */
    public static final Integer NOT_DELETE_STATUS = 0;


    /**
     * 已锁定
     */
    public static final Integer HAD_LOCKED = 1;

    /**
     * 未锁定
     */
    public static final Integer NOT_LOCKED = 0;

    /**
     * 管理后台初始密码
     */
    public static final String ORIGIN_PASSWORD = "leek-coder";


    /**
     * 隐藏
     */
    public static final Integer HIDE = 1;


    /**
     * 不隐藏
     */
    public static final Integer NOT_HIDE = 0;


    /**
     * 分类 正常 0
     */
    public static final Integer CATEGORY_NORMAL_STATUS = 0;

    /**
     * 分类 删除1
     */
    public static final Integer CATEGORY_DELETE_STATUS = 1;


}