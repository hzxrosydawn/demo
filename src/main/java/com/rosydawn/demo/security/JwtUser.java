package com.rosydawn.demo.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用于 JSON Web Token 验证的 UserDetails 接口实现
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 10:46
 */
public class JwtUser implements UserDetails {
    private final String userEmail;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final String userType;

    public JwtUser(
            String userEmail,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            boolean enabled,
            String userType) {
        this.userEmail = userEmail;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.userType = userType;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    public String getUserType() {
        return userType;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
