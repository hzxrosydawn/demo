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
public class Dict {
	private Long logicId;

	private String item;

    private String value;

    private String type;

    private String label;

    private String description;

    private Integer sort;

    private String remark;

    private BooleanEnum deleteEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;
}