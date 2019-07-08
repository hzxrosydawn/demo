package com.rosydawn.demo.model;

import com.rosydawn.demo.constants.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String comments;

    /**
     * 是否假删除
     */
    private BooleanEnum deleted;

    private Date createTime;
    private Date updateTime;
}
