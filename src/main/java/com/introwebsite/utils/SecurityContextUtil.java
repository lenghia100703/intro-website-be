package com.introwebsite.utils;

import com.introwebsite.configs.CustomAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextUtil {
    public static Long getCurrentUserId() {
        if (SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            return null;
        }
        CustomAuthentication authentication = (CustomAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getId();
    }
}
