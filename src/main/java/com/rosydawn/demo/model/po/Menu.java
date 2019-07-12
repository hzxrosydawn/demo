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
public class Menu {
	private Long logicId;

    private String name;

    private String remark;

    private String url;

    private Long parentId;

    private String perms;

    private Integer type;

    private Integer orderNum;

    private BooleanEnum deleteEnum;

	private User creator;

	private Date createTime;

	private User modifier;

	private Date updateTime;
}