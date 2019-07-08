package com.rosydawn.demo.service.impl;

import com.rosydawn.demo.dao.UserRepository;
import com.rosydawn.demo.model.Role;
import com.rosydawn.demo.model.User;
import com.rosydawn.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
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
    public List<Role> getUserRolesById(Long id) {
        return null;
    }

    @Override
    public List<GrantedAuthority> getUserRolesByUserId(Long id) {
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public Long addUser(User user) {
        return null;
    }

    @Override
    public Long updateUser(User user) {
        return null;
    }

    @Override
    public Long addUsers(List<User> userList) {
        return null;
    }

    @Override
    public Long updateUsers(List<User> userList) {
        return null;
    }

    @Override
    public Long deleteUserById(Long userId) {
        return null;
    }

    @Override
    public Long deleteUserByEmail(String userEmail) {
        return null;
    }
}
