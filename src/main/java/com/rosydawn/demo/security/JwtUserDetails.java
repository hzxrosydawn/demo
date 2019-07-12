package com.rosydawn.demo.security;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import com.rosydawn.demo.model.po.Dept;
import com.rosydawn.demo.model.po.Role;
import com.rosydawn.demo.model.po.Group;
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
public class JwtUserDetails implements UserDetails {
    /**
     * 数据库逻辑Id
     */
    private Long logicId;

    /**
     * 登录用户名，邮箱用户名
     */
    private String loginName;

    /**
     * 注册邮箱
     */
    private String email;

    /**
     * 用户姓名
     */
    private String chineseName;

    /**
     * 经过摘要计算的用户密码
     */
    private String hashedPassword;

    /**
     * 用户的部门
     */
    private Dept dept;

    /**
     * 用户是否过期
     */
    private BooleanEnum userNonExpiredEnum;

    /**
     * 用户是否锁定
     */
    private BooleanEnum userNonLockedEnum;

    /**
     * 用户密码是否过期
     */
    private BooleanEnum passwordNonExpiredEnum;

    /**
     * 用户是否被禁用
     */
    private BooleanEnum enabledEnum;

    /**
     * 用户是否被假删除
     */
    private BooleanEnum deleted;

    private Date createTime;

    private Date updateTime;

    private List<Role> roleList;

    private List<Group> groupList;

    /**
     * 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过
     *
     * 用户已经被授予的权限可以从角色、用户组中提取、合并、去重后得出
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO
        return null;
    }

    @Override
    public String getPassword() {
        return this.hashedPassword;
    }

    @Override
    public String getUsername() {
        return this.loginName;
    }

    /**
     * 帐号是否不过期，false则验证不通过
     */
    @Override
    public boolean isAccountNonExpired() {
        return BooleanEnum.TRUE == this.userNonExpiredEnum;
    }

    /**
     * 帐号是否未锁定，false则验证不通过
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.userNonLockedEnum == BooleanEnum.TRUE;
    }

    /**
     * 密码是否未过期，false则验证不通过
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return BooleanEnum.TRUE == this.passwordNonExpiredEnum;
    }

    /**
     * 帐号是否可用，false则验证不通过
     */
    @Override
    public boolean isEnabled() {
        return BooleanEnum.TRUE == this.enabledEnum;
    }
}
