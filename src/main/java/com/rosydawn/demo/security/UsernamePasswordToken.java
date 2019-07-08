package com.rosydawn.demo.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/8 11:17
 */
public class UsernamePasswordToken extends AbstractAuthenticationToken      {
    private String username;
    private String password;

    public UsernamePasswordToken(Collection<? extends GrantedAuthority> authorities, String username, String password) {
        super(authorities);
        this.username = username;
        this.password = password;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
