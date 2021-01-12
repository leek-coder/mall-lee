package com.huatech.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatech.mall.mapper.BookMapper;
import com.huatech.mall.model.Book;
import com.huatech.mall.service.ReadBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/

@Service
@Transactional(rollbackFor = Exception.class)
public class ReadBookServiceImpl implements ReadBookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public int getBookCount() {
        return bookMapper.queryBookCount();
    }

    @Override
    public List<Book> getPageList(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Book> lists = bookMapper.findBookByParams(new Book());
        PageInfo pageInfo = new PageInfo(lists);
        return pageInfo.getList();
    }


}
