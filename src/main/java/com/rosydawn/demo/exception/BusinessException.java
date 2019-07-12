package com.rosydawn.demo.exception;


import com.rosydawn.demo.constants.enums.BusinessCodeMsgEnum;

/**
 * 强制业务异常必须提供 code 码，便于统一维护
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 9:24
 */
public class BusinessException extends RuntimeException {
    private final BusinessCodeMsgEnum msg;

    private Object data;

    public BusinessException(BusinessCodeMsgEnum msg){
        this.msg = msg;
    }

    public BusinessException(BusinessCodeMsgEnum msg, Object data){
        this.msg = msg;
        this.data = data;
    }

    public BusinessCodeMsgEnum getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
