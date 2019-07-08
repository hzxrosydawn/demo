package com.rosydawn.demo.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/8 11:21
 */
public final class SpringSecurityUtil {
    private SpringSecurityUtil(){}
    public static String getUserEmail() {
        String temp = "";
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(null != authentication){
                temp = authentication.getName();
            }
        } catch (Exception e) {
            temp = "";
        }
        return temp;
    }

    public static JwtUser getJwtUser(){
        Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getClass().isAssignableFrom(AnonymousAuthenticationToken.class)){
            return null;
        }else{
            JwtUser info = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return info;
        }

    }
}
