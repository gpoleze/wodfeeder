package com.gabrielpf.wodfeeder.model.auth;

import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.EnumUtils;

import com.gabrielpf.wodfeeder.security.oauth2.user.GoogleOAuth2UserInfo;
import com.gabrielpf.wodfeeder.security.oauth2.user.OAuth2UserInfo;

public enum AuthProvider {
    GOOGLE(GoogleOAuth2UserInfo::new);

    private final Function<Map<String, Object>, ? extends OAuth2UserInfo> oAuthUserInfoFunction;

    AuthProvider(Function<Map<String, Object>, ? extends OAuth2UserInfo> oAuthUserInfoFunction) {
        this.oAuthUserInfoFunction = oAuthUserInfoFunction;
    }

    public static boolean hasValue(String value) {
        return EnumUtils.isValidEnum(AuthProvider.class, value);
    }

    public OAuth2UserInfo getUserInfo(Map<String, Object> attributes){
        return this.oAuthUserInfoFunction.apply(attributes);
    }
}
