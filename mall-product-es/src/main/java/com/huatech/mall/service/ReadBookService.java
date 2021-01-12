package com.huatech.mall.service;


import com.huatech.mall.model.Book;

import java.util.List;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
public interface ReadBookService {

    /**
     * 获取书籍数量
     *
     * @return
     */
    public int getBookCount();

    /**
     * 分页获取书籍列表
     *
     * @param page
     * @param size
     * @return
     */
    public List<Book> getPageList(Integer page, Integer size);
}
