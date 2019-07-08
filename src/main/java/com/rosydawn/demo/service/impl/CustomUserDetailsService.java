package com.rosydawn.demo.service.impl;

import com.rosydawn.demo.dao.UserRepository;
import com.rosydawn.demo.model.User;
import com.rosydawn.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/8 17:27
 */
@Component
@Slf4j
public class CustomUserDetailsService implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Get User from DB by：{}...", email);
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email does not exists!");
        }

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        org.springframework.security.core.userdetails.User user1 =
                new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), simpleGrantedAuthorities);
        log.info("Get User:", user1);
        return user1;
    }

}
