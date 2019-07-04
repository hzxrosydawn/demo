package com.rosydawn.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/4 17:36
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    private Long logicId;
    private String userName;
    private String email;
    private Long deptId;
    private Date createTime;
    private Date updateTime;
}
