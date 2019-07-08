package com.rosydawn.demo.exception;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 9:24
 */
public class UserForceLoginOutException extends AuthenticationException {
    public UserForceLoginOutException(String msg) {
        super(msg);
    }
}
