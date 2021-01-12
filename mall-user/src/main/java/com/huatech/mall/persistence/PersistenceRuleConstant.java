package com.huatech.mall.persistence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author like
 * @date 2020-12-31 3:41 下午
 **/
public class PersistenceRuleConstant {

    /**
     * 存储文件路径
     */
    public static final String STORE_PATH = "/Users/like/data/sentinel/";

    /**
     * 各种存储sentinel规则映射map
     */
    public static final Map rulesMap = new HashMap<String, String>();

    /**
     * 流控规则文件
     */
    public static final String FLOW_RULE_PATH = "flowRule";

    /**
     * 降级规则文件
     */
    public static final String DEGRAGE_RULE_PATH = "degradeRule";

    /**
     * 授权规则文件
     */
    public static final String AUTH_RULE_PATH = "authRule";

    /**
     * 系统规则文件
     */
    public static final String SYSTEM_RULE_PATH = "systemRule";

    /**
     * 热点参数文件
     */
    public static final String HOT_PARAM_RULE = "hotParamRule";

    static {
        rulesMap.put(FLOW_RULE_PATH, STORE_PATH + "flowRule.json");
        rulesMap.put(DEGRAGE_RULE_PATH, STORE_PATH + "degradeRule.json");
        rulesMap.put(SYSTEM_RULE_PATH, STORE_PATH + "systemRule.json");
        rulesMap.put(AUTH_RULE_PATH, STORE_PATH + "authRule.json");
        rulesMap.put(HOT_PARAM_RULE, STORE_PATH + "hotParamRule.json");
    }
}
