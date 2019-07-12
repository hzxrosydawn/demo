package com.rosydawn.demo.security;

import com.alibaba.druid.support.json.JSONUtils;
import com.rosydawn.demo.constants.enums.BusinessCodeMsgEnum;
import com.rosydawn.demo.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义处理登录失败
 *
 * @auther: Vincent Huang
 * Created on 2019/7/12 11:22
 */
@Slf4j
@Component
public class JsonAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        Result<String> loginFailResult = new Result<>();
        loginFailResult.setCode(BusinessCodeMsgEnum.paramError.getCode());
        loginFailResult.setMsg(exception.getMessage());
        response.getWriter().write(JSONUtils.toJSONString(loginFailResult));
    }
}
