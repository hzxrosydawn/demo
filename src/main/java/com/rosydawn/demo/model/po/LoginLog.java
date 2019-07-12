package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.LoginResultEnum;
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
public class LoginLog {

    private String emailName;

    private LoginResultEnum loginResultEnum;

	private String loginIp;

	private String localIp;

	private User creator;

	private Date createTime;
}