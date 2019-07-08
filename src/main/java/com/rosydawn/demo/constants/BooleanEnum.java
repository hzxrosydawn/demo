package com.rosydawn.demo.constants;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/8 15:42
 */
public enum BooleanEnum {
    TRUE(1, "是"),
    FALSE(0, "否");

    private final int code;
    private final String desc;

    BooleanEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UserStatusEnum{" +
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
