package com.rosydawn.demo.model;

import com.rosydawn.demo.constants.BooleanEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 实现 UserDetails 接口，以便衔接 Spring Security 和 数据库。
 *
 * @auther: Vincent Huang
 * Created on 2019/7/4 17:36
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User implements UserDetails {
    /**
     * 数据库逻辑Id
     */
    private Long logicId;

    /**
     * 注册邮箱
     */
    private String email;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 经过摘要计算的用户密码
     */
    private String hashedPassword;

    /**
     * 用户的部门Id
     */
    private Long deptId;

    /**
     * 帐号是否过期
     */
    private BooleanEnum accountExpired;

    /**
     * 帐号是否锁定
     */
    private BooleanEnum accountLocked;

    /**
     * 密码是否过期
     */
    private BooleanEnum credentialsExpired;

    /**
     * 是否假删除
     */
    private BooleanEnum deleted;

    private Date createTime;

    private Date updateTime;

    /**
     * 用户已经被授予的权限
     */
    List<GrantedAuthority> grantedAuthorityList;

    // 重写 UserDetails 中的方法
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.hashedPassword;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountExpired == BooleanEnum.FALSE;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountLocked == BooleanEnum.FALSE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsExpired == BooleanEnum.FALSE;
    }

    @Override
    public boolean isEnabled() {
        return this.deleted == BooleanEnum.FALSE;
    }
}
