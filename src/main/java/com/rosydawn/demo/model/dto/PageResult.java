package com.rosydawn.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通用的分页结果
 *
 * @auther: Vincent
 * Date: 2019/7/2
 * Time: 20:00
 */
@Data
@NoArgsConstructor
public class PageResult<T> {
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
     * 当前页的数据列表
     */
    private List<T> data;
}
