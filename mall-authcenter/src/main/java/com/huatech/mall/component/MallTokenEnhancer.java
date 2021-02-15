package com.huatech.mall.component;

import com.huatech.mall.entity.MemberDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * 增强jwt
 * 实现TokenEnhancer 我们的jwt可以塞入我们的用户业务信息
 * @author like
 * @date 2021-02-12 3:52 下午
 **/
public class MallTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();

        final Map<String, Object> userInfo = new HashMap<>();

        final Map<String, Object> retMap = new HashMap<>();

        //这里暴露memberId到Jwt的令牌中,后期可以根据自己的业务需要 进行添加字段
        userInfo.put("id", memberDetails.getUser().getId());
        userInfo.put("nickName", memberDetails.getUser().getNickName());
        userInfo.put("integration", memberDetails.getUser().getUserName());
        retMap.put("userInfo", userInfo);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(retMap);
        return accessToken;
    }
}
