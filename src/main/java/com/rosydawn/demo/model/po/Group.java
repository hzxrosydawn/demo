package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 用户组
 *
 * @auther: Vincent Huang
 * Created on 2019/7/10 16:14
 */
@Data
@NoArgsConstructor
public class Group {
    private Long logicId;

    private String groupName;

    private String remark;

    private BooleanEnum deleted;

    private List<Role> roleList;

    private BooleanEnum deleteEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;
}
