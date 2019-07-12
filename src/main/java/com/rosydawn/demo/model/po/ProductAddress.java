package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 11:07
 */
@Data
@NoArgsConstructor
public class ProductAddress {
    private Long logicId;

    private Product product;

    /**
     * ip 地址
     */
    private String address;

    /**
     * 端口号
     */
    private String port;

    private BooleanEnum deletedEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;

}
