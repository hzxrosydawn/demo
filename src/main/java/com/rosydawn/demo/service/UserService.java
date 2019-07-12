package com.rosydawn.demo.service;

import com.rosydawn.demo.model.po.User;
import com.rosydawn.demo.security.JwtUserDetails;

import java.util.List;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/5 9:29
 */
public interface UserService {
    Long add(User user);

    User getByUsername(String username);

    User getByUserId(Long logicId);

    List<JwtUserDetails> getAllUsers();

    List<String> getAuthorityListByUsername(String username);

    Long updateUser(User user);

    Long deleteById(Long userId);

    Long deleteByEmail(String userEmail);
}
