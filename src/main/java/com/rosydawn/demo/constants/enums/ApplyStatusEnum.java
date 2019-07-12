package com.rosydawn.demo.constants.enums;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 14:19
 */
public enum ApplyStatusEnum {
    APPLIED_TO_APPROVE(1, "已申请待批准"),
    APPROVED_TO_IMPLEMENT(2, "已批准待实施"),
    IMPLEMENT_TO_USE(3, "已实施可使用"),
    APPLY_SEND_BACK(4, "申请已被退回");

    private final int code;
    private final String desc;

    ApplyStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ApplyStatusEnum{" +
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
