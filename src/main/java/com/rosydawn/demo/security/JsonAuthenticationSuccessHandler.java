package com.rosydawn.demo.security;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义处理登录成功
 *
 * @auther: Vincent Huang
 * Created on 2019/7/12 11:12
 */
@Slf4j
@Component
public class JsonAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        response.setContentType("application/json;charset=UTF-8");
        // 一般登录成功了都是进行了页面的跳转，但在前后端分离的情况下，登录成功了可能需要向前端返回用户的个人信息，而不是直接进行跳转
        // 登录失败也是同样的道理
        response.getWriter().write(JSONUtils.toJSONString(authentication));
    }
}
