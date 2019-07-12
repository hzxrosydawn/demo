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
public class OptLog {
	private Long logicId;

	private Long userId;

	private String operation;

	private String method;

    private String params;

    private Long duration;

    private String ip;

    private String localIp;

    private BooleanEnum needToWarnEnum;

	private User creator;

	private Date createTime;

	private User modifier;

	private Date updateTime;


}