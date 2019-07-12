package com.rosydawn.demo.model.po;

import com.rosydawn.demo.constants.enums.ApplyStatusEnum;
import com.rosydawn.demo.constants.enums.BooleanEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/11 11:14
 */
@Data
@NoArgsConstructor
public class AccountApply {
    private Long logicId;

    /**
     * 帐号申请单号
     */
    private String seqNum;

    private Product product;

    private Dict productType;

    /**
     * 申请的权限描述
     */
    private String permissionDesc;

    /**
     * 申请帐号的密码过期天数
     */
    private Integer expireDuration;

    /**
     * 文件存储路径
     */
    private String appendixPath;

    /**
     * 申请单状态
     */
    private ApplyStatusEnum applyStatusEnum;

    /**
     * 结束时间
     */
    private Date finishedTime;

    private BooleanEnum needToWarnEnum;

    private User creator;

    private Date createTime;

    private User modifier;

    private Date updateTime;

}
