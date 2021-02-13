package com.huatech.mall.component;


/**
 *
 * @author like
 * @date 2020-06-22 3:09 下午
 **/
public interface ZkLock {

    /**
     * 加锁
     * @param path
     * @return
     */
    boolean lock(String path);

    /**
     * 释放锁
     * @param path
     * @return
     */
    boolean unlock(String path);

}
