package com.rosydawn.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Spring Security 配置
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 9:24
 */
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;
    }

    /**
     * 使用Spring Security自带的 OpenBSD 风格的 Blowfish 摘要算法。
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)   // 指定该 WebSecurityConfigurerAdapter 是被首先应用的
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/api/**")  // 该 HttpSecurity 仅用于 /api/ 开头的 URL
                    .authorizeRequests()
                    .anyRequest().hasRole("ADMIN")
                    .and()
                    .httpBasic();
        }
    }

    @Configuration  // 没有 @Order 注解的 WebSecurityConfigurerAdapter 默认为最后应用
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()            // 该 WebSecurityConfigurerAdapter 会处理非 /api/ 开头的 URL
                    .anyRequest().authenticated()   // 任何请求,登录后可以访问
                    .and()
                    .formLogin();                   //  定义当需要用户登录时候，转到的登录页面
        }
    }
}
