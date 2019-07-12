package com.rosydawn.demo.exception;


import com.rosydawn.demo.constants.enums.BusinessCodeMsgEnum;

/**
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 9:24
 */
public class UserHasOnlineException extends BusinessException {
    public UserHasOnlineException(BusinessCodeMsgEnum msg){
        super(msg);
    }
}
