package com.rosydawn.demo.security.service;

import com.rosydawn.demo.security.JwtUserDetails;
import com.rosydawn.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户登录认证信息查询
 * @author Louis
 * @date Jan 14, 2019
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名：{}", username);
        JwtUserDetails jwtUserDetails = userService.getByUsername(username);

        if (jwtUserDetails == null) {
            throw new UsernameNotFoundException("用户名 " + username + " does not exists!");
        }
        log.info("Get JwtUserDetails:", jwtUserDetails);
        jwtUserDetails.set
        return jwtUserDetails;
    }
}