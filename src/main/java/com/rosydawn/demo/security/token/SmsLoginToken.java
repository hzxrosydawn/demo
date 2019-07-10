package com.rosydawn.demo.security.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 短信验证码登录 Token
 *
 * @auther: Vincent Huang
 * Created on 2019/7/10 13:57
 */
public class SmsLoginToken extends AbstractAuthenticationToken {
    private final String phone;
    private final String verifyCode;

    public SmsLoginToken(Collection<? extends GrantedAuthority> authorities, String phone, String verifyCode) {
        super(authorities);
        this.phone = phone;
        this.verifyCode = verifyCode;
    }

    @Override
    public Object getCredentials() {
        return verifyCode;
    }

    @Override
    public Object getPrincipal() {
        return phone;
    }
}
