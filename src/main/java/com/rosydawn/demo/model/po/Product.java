package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 11:04
 */
@Data
@NoArgsConstructor
public class Product {
    private Long logicId;

    private String name;

    private Dict productType;

    private User operator;

    private User viceOperator;

    private BooleanEnum deletedEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;
}
