package com.rosydawn.demo.service.impl;

import com.rosydawn.demo.model.po.User;
import com.rosydawn.demo.security.JwtUserDetails;
import com.rosydawn.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
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
    public JwtUserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException, DataAccessException {
        log.info("Method login name parameter ：{}", loginName);
        User user = userService.getByUsername(loginName);

        if (user == null) {
            throw new UsernameNotFoundException("The login name '" + loginName + "' does not exists!");
        }
        log.info("Get User:", user);

        JwtUserDetails jwtUserDetails = new JwtUserDetails();
        // TODO 配置jwtUserDetails的用户权限和帐号信息

        return jwtUserDetails;
    }
}