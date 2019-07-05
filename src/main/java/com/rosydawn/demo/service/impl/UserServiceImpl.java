package com.rosydawn.demo.service.impl;

import com.rosydawn.demo.model.User;
import com.rosydawn.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/5 10:12
 */
@Service
public class UserServiceImpl implements UserService {
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
