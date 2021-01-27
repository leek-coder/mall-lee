package com.jrx.common.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author like
 * @date 2019-12-11 4:20 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {
    private String token;
    private Long expiration;
}