package com.rosydawn.demo.exception;


import com.rosydawn.demo.constants.CodeMsg;

/**
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 9:24
 */
public class UserHasOnlineException extends BusinessException {
    public UserHasOnlineException(CodeMsg msg){
        super(msg);
    }
}
