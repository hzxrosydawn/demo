package com.rosydawn.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果对象,这里以layui框架的table为标准
 *
 * @auther: Vincent
 * Date: 2019/7/2
 * Time: 20:00
 */
@Data
@NoArgsConstructor
public class PageResult<T> {
    /**
     * 状态码, 0表示成功
     */
    private int code;

    private String msg;

    /**
     * 总数量, bootstrapTable是total
     */
    private long totalCount;

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 第几页
     */
    private int pageNum;

    /**
     * 每页数量大小
     */
    private int pageSize;

    /**
     * 当前数据, bootstrapTable是rows
     */
    private List<T> data;
}
