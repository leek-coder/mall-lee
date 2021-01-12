package com.huatech.mall.controller;

import com.github.pagehelper.PageHelper;
import com.huatech.mall.model.Book;
import com.huatech.mall.service.ReIndexService;
import com.huatech.mall.service.ReadBookService;
import com.jrx.common.response.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author like
 * @date 2021-01-10 9:02 下午
 **/
@Controller
@RequestMapping("/read/book")
public class ReadBookController {

    @Resource
    private ReadBookService readBookPdService;
    @Resource
    ReIndexService indexService;

    @PostMapping
    public ResponseResult add(@RequestBody Book book) {
//        readBookPdService.save(readBookPd);
        return ResponseResult.success();
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
//        readBookPdService.deleteById(id);
        return ResponseResult.success();
    }

    @PutMapping
    public ResponseResult update(@RequestBody Book book) {
//        readBookPdService.update(readBookPd);
        return ResponseResult.success();
    }

    @GetMapping("/{id}")
    public ResponseResult detail(@PathVariable Integer id) {
//        ReadBookPd readBookPd = readBookPdService.findById(id);
        return ResponseResult.success(null);
    }

    @GetMapping("/indexall")
    public ResponseResult indexAll() {
        indexService.reIndexBooks();
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
//        List<ReadBookPd> list = readBookPdService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
        return ResponseResult.success(null);
    }
}
