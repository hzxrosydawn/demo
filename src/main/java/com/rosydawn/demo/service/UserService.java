package com.rosydawn.demo.service;

import com.rosydawn.demo.model.User;

import java.util.List;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/5 9:29
 */
public interface UserService {
    User getUserById(Long userId);
    List<User> getAllUsers();
    User getUserByEmail(String userEmail);
    Long addUser(User user);
    Long updateUser(User user);
    Long addUsers(List<User> userList);
    Long updateUsers(List<User> userList);
    Long deleteUserById(Long userId);
    Long deleteUserByEmail(String userEmail);
}
