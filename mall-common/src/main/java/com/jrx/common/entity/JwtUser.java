package com.jrx.common.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName JwtUser
 * @Description TODO
 * @Author like
 * @Date 2019-12-11 13:33
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtUser {

    private Long id;
    private String userName;
    private String nickName;

}
