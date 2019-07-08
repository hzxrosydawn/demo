package com.rosydawn.demo.service;

import com.rosydawn.demo.model.Role;
import com.rosydawn.demo.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 *
 * @auther: Vincent Huang
 * Created on 2019/7/5 9:29
 */
public interface UserService {
    User getUserById(Long logicId);
    List<Role> getUserRolesById(Long id);
    List<User> getAllUsers();
    User getUserByEmail(String userEmail);
    Long addUser(User user);
    Long updateUser(User user);
    Long addUsers(List<User> userList);
    Long updateUsers(List<User> userList);
    Long deleteUserById(Long userId);
    Long deleteUserByEmail(String userEmail);
    List<GrantedAuthority> getUserRolesByUserId(Long id);
}
