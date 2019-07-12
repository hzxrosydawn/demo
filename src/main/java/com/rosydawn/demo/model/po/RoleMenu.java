package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 15:15
 */
@Data
@NoArgsConstructor
public class RoleMenu {
    private Long logicId;

    private Role role;

    private Menu menu;

    private BooleanEnum deletedEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;
}
