package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 15:24
 */
@Data
@NoArgsConstructor
public class GroupRole {
    private Long logicId;

    private Group group;

    private Role role;

    private BooleanEnum deleteEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;
}
