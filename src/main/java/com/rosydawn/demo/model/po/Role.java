package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 *
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 10:55
 */
@Data
@NoArgsConstructor
public class Role {
    private Long id;
    private String roleName;

    /**
     * 角色注释
     */
    private String remark;

    /**
     * 关联的菜单列表
     */
    private List<Menu> menuList;

    /**
     * 是否假删除
     */
    private BooleanEnum deletedEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;
}
