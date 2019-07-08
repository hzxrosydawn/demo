package com.rosydawn.demo.exception;


import com.rosydawn.demo.constants.CodeMsg;

/**
 * 强制业务异常必须提供 code 码，便于统一维护
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 9:24
 */
public class BusinessException extends RuntimeException {
    private final CodeMsg msg;

    private Object data;

    public BusinessException(CodeMsg msg){
        this.msg = msg;
    }

    public BusinessException(CodeMsg msg,Object data){
        this.msg = msg;
        this.data = data;
    }

    public CodeMsg getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
