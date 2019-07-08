package com.rosydawn.demo.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录接口封装对象
 *
 * @author Louis
 * @date Oct 29, 2018
 */
@Data
@NoArgsConstructor
public class LoginBean {
	private String email;
	private String password;
	private String captcha;
}
