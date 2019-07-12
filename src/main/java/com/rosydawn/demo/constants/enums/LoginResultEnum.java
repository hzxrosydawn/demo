package com.rosydawn.demo.constants.enums;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 10:51
 */
public enum LoginResultEnum {
    LOGIN_SUCCESS(1, "登录成功"),
    LOGOUT_SUCCESS(2, "退出成功"),
    ERROR_PASS(3, "密码错误"),
    USER_LOCKED(4, "帐号被锁定");

    private final int code;
    private final String desc;

    LoginResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "LoginResultEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
