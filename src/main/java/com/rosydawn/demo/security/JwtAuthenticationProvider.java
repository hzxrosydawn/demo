package com.rosydawn.demo.security;

import com.rosydawn.demo.constants.CodeMsg;
import com.rosydawn.demo.exception.IllegalTokenException;
import com.rosydawn.demo.model.User;
import com.rosydawn.demo.service.UserService;
import com.rosydawn.demo.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/8 10:36
 */
@Slf4j
public class JwtAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String token = (String) authentication.getCredentials();
            // 实际项目中用户信息放在 Redis 中，从 Redis 中读取，使用 Redis 还可以方便的集成单点登录问题，用于用户踢出，检测用户是否登录
            String userEmail = jwtTokenUtil.getUserEmailFromToken(token);
            User userInfo = userService.getUserByEmail(userEmail);
            List<GrantedAuthority> authorityList = userService.getUserRolesByUserId(userInfo.getLogicId());
            JwtUser user = new JwtUser(userEmail, "", authorityList, true, "");
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, authorityList);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return authToken;
        } catch (Exception e) {
            log.error("登录异常", e);
            throw new IllegalTokenException(CodeMsg.tokenIllegal.getMsg());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthToken.class.equals(authentication);
    }

}
