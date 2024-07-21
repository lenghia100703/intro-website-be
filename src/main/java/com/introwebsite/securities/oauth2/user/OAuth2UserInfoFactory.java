package com.introwebsite.securities.oauth2.user;

import com.introwebsite.exceptions.CommonException;

import java.util.Map;

import static com.introwebsite.enums.AuthProvider.GOOGLE;
import static com.introwebsite.enums.ResponseCode.ERROR;


public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(GOOGLE.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new CommonException(ERROR, "Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
