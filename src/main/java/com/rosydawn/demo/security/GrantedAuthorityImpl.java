package com.rosydawn.demo.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 *
 * @author Vincent Huang
 * @date July 8, 2019
 */
@ToString
@Setter
@Getter
public class GrantedAuthorityImpl implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }
}