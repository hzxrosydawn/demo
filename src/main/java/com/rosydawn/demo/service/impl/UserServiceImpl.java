package com.rosydawn.demo.service.impl;

import com.rosydawn.demo.dao.UserRepository;
import com.rosydawn.demo.security.JwtUserDetails;
import com.rosydawn.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/5 10:12
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public Long add(JwtUserDetails jwtUserDetails) {
        return null;
    }

    @Override
    public JwtUserDetails getByUsername(String username) {
        return null;
    }

    @Override
    public JwtUserDetails getByUserId(Long logicId) {
        return null;
    }

    @Override
    public List<JwtUserDetails> getAllUsers() {
        return null;
    }

    @Override
    public List<String> getAuthorityListByUsername(String username) {
        return null;
    }

    @Override
    public Long updateUser(JwtUserDetails jwtUserDetails) {
        return null;
    }

    @Override
    public Long deleteById(Long userId) {
        return null;
    }

    @Override
    public Long deleteByEmail(String userEmail) {
        return null;
    }
}
