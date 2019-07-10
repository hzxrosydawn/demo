package com.rosydawn.demo.model.po;

import lombok.Data;
import lombok.NoArgsConstructor;

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
     * 注册邮箱
     */
    private String email;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户分机或手机号
     */
    private String phone;

    /**
     * 用户的部门
     */
    private Dept dept;
}
