package com.huatech.mall.controller.upload;

import com.huatech.mall.config.FastClientWrapper;
import com.huatech.mall.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * 图片上传控制器
 *
 * @author like
 * @date 2019-12-19 7:57 下午
 **/
@RestController
@RequestMapping(value = "/pic")
@Slf4j
public class PicUploadController {

    @Autowired
    private FastClientWrapper clientWrapper;

    @PostMapping(value = "/upload")
    @ResponseBody
    public ResponseResult productUpload(MultipartFile file) {
        Map<String, String> map = null;
        if (file != null) {
            try {
                map = clientWrapper.uploadFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseResult.success(map);
    }

}