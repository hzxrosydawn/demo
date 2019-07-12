package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 14:32
 */
@Data
@NoArgsConstructor
public class Account {
    private Long logicId;

    private AccountApply accountApply;

    private Dict productType;

    private Product product;

    /**
     * 申请帐号的密码过期天数
     */
    private Integer expireDuration;

    private BooleanEnum expiredEnum;

    private String assignedAccountName;

    private String assignedPassword;

    /**
     * 实施后管理员分配帐号的属组列表，多个属组以英文逗号分隔
     */
    private String assignedGroups;

    private BooleanEnum needToWarnEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;
}
