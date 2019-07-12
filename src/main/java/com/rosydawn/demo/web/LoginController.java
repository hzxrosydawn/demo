package com.rosydawn.demo.web;

import com.rosydawn.demo.constants.enums.BusinessCodeMsgEnum;
import com.rosydawn.demo.model.dto.LoginBean;
import com.rosydawn.demo.model.dto.Result;
import com.rosydawn.demo.security.JwtUserDetails;
import com.rosydawn.demo.security.token.JwtAuthenticationToken;
import com.rosydawn.demo.service.UserService;
import com.rosydawn.demo.service.impl.UserDetailsServiceImpl;
import com.rosydawn.demo.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 *
 * @auther: Vincent Huang
 * Created on 2019/7/11 14:19
 */
@RestController
@Slf4j
public class LoginController {
	@Resource
	private UserDetailsServiceImpl userDetailsService;

	@Resource
	private UserService userService;

	@Resource
	private AuthenticationManager authenticationManager;

	/**
	 * 登录接口
	 */
	@PostMapping(value = "/login")
	public Result<JwtAuthenticationToken> login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
		String loginName = loginBean.getLoginName();
		String password = loginBean.getPassword();

		// 用户信息
		JwtUserDetails jwtUserDetails = userDetailsService.loadUserByUsername(loginName);

		// 账号不存在、密码错误
		if (jwtUserDetails == null) {
			return Result.of(BusinessCodeMsgEnum.principalIncorrect.getCode(), BusinessCodeMsgEnum.principalIncorrect.getMsg());
		}

		// 账号锁定
		if (jwtUserDetails.getStatus() == 0) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}

		// 系统登录认证
		JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
		return HttpResult.ok(token);
	}

	/*
	@Resource
	private Producer producer;

	@GetMapping("captcha.jpeg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}*/
}
