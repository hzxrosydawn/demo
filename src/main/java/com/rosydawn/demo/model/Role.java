package com.rosydawn.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 *
 * @auther: Vincent Huang
 * Created on 2019/7/8 10:55
 */
@Data
@NoArgsConstructor
public class Role {
    private Long id;
    private String roleName;
    private String comments;
    private Date createTime;
    private Date updateTime;
}
