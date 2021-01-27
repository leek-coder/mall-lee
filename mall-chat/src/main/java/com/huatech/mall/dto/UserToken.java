package com.huatech.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author like
 * @date 2021-01-27 3:14 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserToken implements Serializable {

    private  String id;
    private  String nickName;
    private  String userName;
}