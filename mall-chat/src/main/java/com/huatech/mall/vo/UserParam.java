package com.huatech.mall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author like
 * @date 2021-01-27 10:59 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserParam implements Serializable {
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户id
     */
    private Long userId;

    private String username;


    private String password;


    private String faceImage;


    private String faceImageBig;


    private String qrcode;


}