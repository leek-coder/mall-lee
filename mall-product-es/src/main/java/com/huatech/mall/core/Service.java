package com.huatech.mall.core;


import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 *
 * @author like
 * @date 2020-08-20 8:07 下午
 **/
public interface Service<T> {

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     *
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     * 通过多个ID查找//eg：ids -> “1,2,3,4”
     *
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);
}
