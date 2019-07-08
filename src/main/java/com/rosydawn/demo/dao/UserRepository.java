package com.rosydawn.demo.dao;

import com.rosydawn.demo.model.User;
import org.springframework.stereotype.Repository;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/8 16:03
 */
@Repository
public interface UserRepository {
    User findUserByEmail(String email);
}
