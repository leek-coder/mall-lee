package com.huatech.mall.config;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @Author leek
 * @Date 2019-11-09 下午4:40
 * @Version 1.0
 * @Description
 */
@Component
public class FastClientWrapper {
    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private FastConfig fastConfig;

    public Map<String, String> uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 封装文件完整URL地址
     *
     * @param storePath
     * @return
     */
    private Map<String, String> getResAccessUrl(StorePath storePath) {
        String fileUrl = "http://" + fastConfig.getResHost() + ":" + fastConfig.getStoragePort() + "/" + storePath.getFullPath();
        Map<String, String> map = new HashedMap();
        map.put("path", fileUrl);
        return map;
    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            e.getMessage();
        }
    }

}
