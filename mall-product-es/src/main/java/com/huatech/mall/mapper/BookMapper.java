package com.huatech.mall.mapper;

import com.huatech.mall.model.Book;

import java.util.List;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/

public interface BookMapper {
    /**
     * 根据主键删除
     *
     * @param id Integer
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存
     *
     * @param record Book
     * @return int
     */
    int insert(Book record);

    /**
     * 根据字段是否为空保存
     *
     * @param record Book
     * @return int
     */
    int insertSelective(Book record);

    /**
     * 根据主键查询
     *
     * @param id Integer
     * @return Book
     */
    Book selectByPrimaryKey(Integer id);

    /**
     * 根据字段是否为空更新
     *
     * @param record Book
     * @return int
     */
    int updateByPrimaryKeySelective(Book record);


    /**
     * 根据主键更新所有字段
     *
     * @param record Book
     * @return int
     */
    int updateByPrimaryKey(Book record);

    /**
     * 查询总记录数
     *
     * @return
     */
    int queryBookCount();

    /**
     * 查询书籍列表
     *
     * @param book
     * @return
     */
    List<Book> findBookByParams(Book book);
}