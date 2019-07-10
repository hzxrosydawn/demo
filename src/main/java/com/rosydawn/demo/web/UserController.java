package com.rosydawn.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 *
 * @auther: Vincent
 * Date: 2019/7/8
 * Time: 19:03
 */
@Slf4j
@Controller
@RequestMapping("${api.version}/user")
public class UserController {
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user/user";
    }

    @PreAuthorize("hasAuthority('get:/v1/user')")
    @GetMapping()
    public PageResult<User> list(HttpServletRequest request) {
        return userService.listUser(new PageParam(request).setDefaultOrder(new String[]{"create_time"}, null));
    }

}
