package com.huatech.mall.pojo.po;

import java.io.Serializable;
import java.util.List;

/**
 * 磁盘入参
 *
 * @author like
 * @date 2020-09-09 9:54 上午
 **/
public class VolumeParam implements Serializable {

    /**
     * 是否同一存储 1：是 2：不是
     */
    private Integer sameStorage;

    private VolumeSys volumeSys;

    private List<VolumeData> volumeData;

    public Integer getSameStorage() {
        return sameStorage;
    }

    public void setSameStorage(Integer sameStorage) {
        this.sameStorage = sameStorage;
    }

    public VolumeSys getVolumeSys() {
        return volumeSys;
    }

    public void setVolumeSys(VolumeSys volumeSys) {
        this.volumeSys = volumeSys;
    }

    public List<VolumeData> getVolumeData() {
        return volumeData;
    }

    public void setVolumeData(List<VolumeData> volumeData) {
        this.volumeData = volumeData;
    }
}