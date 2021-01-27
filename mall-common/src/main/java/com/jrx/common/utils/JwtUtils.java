package com.jrx.common.utils;

import com.jrx.common.entity.JwtUser;
import com.jrx.common.enums.ApiErrorCodeEnum;
import com.jrx.common.exception.ExceptionCustomer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtUtils
 * @Description TODO
 * @Author like
 * @Date 2019-07-31 13:37
 * @Version 1.0
 **/
@Component
@Slf4j
public class JwtUtils {

    private static final String CLAIM_KEY_USERNAME = "userName";
    private static final String CLAIM_KEY_NICKNAME = "nickName";
    private static final String CLAIM_KEY_USER_ID = "id";
    private static final String CLAIM_KEY_CREATED = "created";
    private static final String CLAIM_KEY_ISS = "iss";
    private static final String CLAIM_KEY_TOKEN_TYPE = "tokenType";
    /**
     * typ属性表示这个令牌的类型，JWT令牌就有JTW
     */
    private static final String JWT_HEADER_KEY = "typ";
    private static final String JWT_HEADER_VALUE = "JWT";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.tokenType}")
    private String tokenType;


    /**
     * 生成token信息
     *
     * @param jwtUser
     * @return
     */
    public Token createToken(JwtUser jwtUser) {
        if (jwtUser != null) {
            Map<String, Object> claims = new HashMap<>();
            // 面向的用户名称
            claims.put(CLAIM_KEY_USERNAME, jwtUser.getUserName());
            // 用户id
            claims.put(CLAIM_KEY_USER_ID, jwtUser.getId());
            // 创建时间
            claims.put(CLAIM_KEY_CREATED, new Date());
            claims.put(CLAIM_KEY_NICKNAME, jwtUser.getNickName());
            // JWT签发者
            claims.put(CLAIM_KEY_ISS, issuer);
            // token类型
            claims.put(CLAIM_KEY_TOKEN_TYPE, tokenType);
            String accessToken = generateToken(claims);
            return Token.builder().token(accessToken).expiration(expiration).build();
        }
        return null;
    }

    String generateToken(Map<String, Object> claims) {
        Date ExpirationDate = generateExpirationDate();
        return Jwts.builder()
                // 添加头部
                .setHeaderParam(JWT_HEADER_KEY, JWT_HEADER_VALUE)
                // 初始化声明 sub created exp
                .setClaims(claims)
                // 初始化有效截止日期
                .setExpiration(ExpirationDate)
                // 初始化签名的算法 以及约定的秘钥
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成access_token有效截止日期
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + (expiration << 5) * 1000);
    }


    /**
     * token中获取用户信息
     */
    public JwtUser getUserFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            String userName = (String) claims.get("userName");
            Integer id = (Integer) claims.get("id");
            long value = id.longValue();
            String nickName = (String) claims.get("nickName");
            JwtUser jwtUser = JwtUser.builder().userName(userName).id(value).nickName(nickName).build();
            return jwtUser;
        } catch (Exception e) {
            throw new ExceptionCustomer(ApiErrorCodeEnum.TOKEN_FAIL);
        }

    }

    /**
     * token中获取声明  里面有用户的所有信息
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

}
