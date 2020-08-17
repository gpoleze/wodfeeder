package com.gabrielpf.wodfeeder.security.oauth2.user;

import java.util.Map;

import com.gabrielpf.wodfeeder.exception.OAuth2AuthenticationProcessingException;
import com.gabrielpf.wodfeeder.model.auth.AuthProvider;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (!AuthProvider.hasValue(registrationId))
            throw new OAuth2AuthenticationProcessingException("Login with " + registrationId +" is not supported");

        AuthProvider authProvider = AuthProvider.valueOf(registrationId.toUpperCase());
        return authProvider.getUserInfo(attributes);
    }
}
