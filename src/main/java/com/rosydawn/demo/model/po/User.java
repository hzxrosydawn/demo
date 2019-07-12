package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/10 17:37
 */
@Data
@NoArgsConstructor
public class User {
    /**
     * 数据库逻辑Id
     */
    private Long logicId;

    /**
     * 登录用的邮箱用户名（邮箱前缀）
     */
    private String loginName;

    /**
     * 用户汉语姓名
     */
    private String username;

    /**
     * 用户分机或手机号
     */
    private String phone;

    /**
     * 邮箱全称
     */
    private String email;

    /**
     * 经过 Spring Boot 内置的 Bcrypt 摘要算法进行计算后的用户密码
     */
    private String password;

    /**
     * 用户的部门
     */
    private Dept dept;

    private BooleanEnum lockEnum;

    private Date lockDate;

    private BooleanEnum expireEnum;

    private Date passwordUpdateTime;

    private Integer expireDuration;

    private BooleanEnum disabledEnum;

    private BooleanEnum deleteEnum;

    private List<Role> roleList;

    private List<Group> groupList;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;


}
