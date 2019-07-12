package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户组
 *
 * @auther: Vincent Huang
 * Created on 2019/7/10 16:14
 */
@Data
@NoArgsConstructor
public class AccountAddress {
    private Long logicId;

    private Account account;

    /**
     * 帐号需要访问的服务器IP地址
     */
    private String address;

    private String port;

    private BooleanEnum deletedEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;

}
